package org.livespark.formmodeler.rendering.client.view;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.livespark.formmodeler.rendering.client.shared.FormModel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;

public abstract class ListItemView<M extends FormModel> extends BaseView<M> {

    @Inject
    @DataField
    protected Button delete;

    @Inject
    @DataField
    protected Button edit;

    @Inject
    protected Event<DeleteEvent<M>> deleteEvent;

    @Inject
    protected Event<EditEvent<M>> editEvent;

    @EventHandler("edit")
    protected void onEdit( ClickEvent e ) {
        editEvent.fire( new EditEvent<M>( getModel() ) );
    }

    @EventHandler("delete")
    protected void onDelete( ClickEvent e ) {
        deleteEvent.fire( new DeleteEvent<M>( getModel() ) );
    }
}
