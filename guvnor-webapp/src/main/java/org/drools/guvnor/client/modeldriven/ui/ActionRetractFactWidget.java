/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.modeldriven.ui;


import com.google.gwt.user.client.ui.HorizontalPanel;
import org.drools.guvnor.client.common.SmallLabel;
import org.drools.guvnor.client.modeldriven.HumanReadable;
import org.drools.ide.common.client.modeldriven.brl.ActionRetractFact;

/**
 * This is used when you want to retract a fact. It will provide a list of
 * bound facts for you to retract.
 */
public class ActionRetractFactWidget extends RuleModellerWidget {

    private boolean readOnly;

    public ActionRetractFactWidget(RuleModeller modeller, ActionRetractFact model) {
        this(modeller, model, null);
    }

    public ActionRetractFactWidget(RuleModeller modeller, ActionRetractFact model, Boolean readOnly) {
        super(modeller);
        HorizontalPanel layout = new HorizontalPanel();
        layout.setWidth("100%");
        layout.setStyleName("model-builderInner-Background");

        if (readOnly == null) {
            this.readOnly = !modeller.getSuggestionCompletions().containsFactType(modeller.getModel().getLHSBindingType(model.variableName));
        } else {
            this.readOnly = readOnly;
        }

        if (this.readOnly) {
            layout.addStyleName("editor-disabled-widget");
        }

        String desc = modeller.getModel().getLHSBindingType(model.variableName) + " [" + model.variableName + "]";
        layout.add(new SmallLabel(HumanReadable.getActionDisplayName("retract") + "&nbsp;<b>" + desc + "</b>"));

        //This widget couldn't be modified.
        this.setModified(false);

        initWidget(layout);
    }

    @Override
    public boolean isReadOnly() {
        return this.readOnly;
    }


}
