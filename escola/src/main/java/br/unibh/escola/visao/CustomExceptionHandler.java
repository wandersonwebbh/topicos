package br.unibh.escola.visao;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
	private final ExceptionHandler wrapped;

	public CustomExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator();
		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();
			Throwable t = context.getException();
			FacesContext fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc
					.getApplication().getNavigationHandler();
			try {
				// HttpSession session = (HttpSession) fc.getExternalContext()
				// .getSession(true);
				// session.setAttribute("erro", t.getMessage());
				// nav.performNavigation("erros.jsf?faces-redirect=true");
				FacesMessage facesMsg;
				facesMsg = null;

				if (t.getMessage().contains("ConstraintViolationException")) {
					facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"CPF já cadastrado!", "");
				} else {
					facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro Desconhecido: " + t.getMessage(), "");
				}

				fc.addMessage("messagePanel", facesMsg);

				fc.renderResponse();
			} finally {
				i.remove();
			}
		}
		getWrapped().handle();
	}
}