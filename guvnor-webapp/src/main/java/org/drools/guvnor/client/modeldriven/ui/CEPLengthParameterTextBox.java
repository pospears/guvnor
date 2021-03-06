/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.guvnor.client.modeldriven.ui;

import org.drools.ide.common.client.modeldriven.brl.HasParameterizedOperator;

import com.google.gwt.regexp.shared.RegExp;

/**
 * A TextBox to handle CEP 'window length' parameters
 */
public class CEPLengthParameterTextBox extends AbstractCEPRestrictedEntryTextBox {

    // A valid Operator parameter expression
    private static final RegExp VALID_LENGTH = RegExp.compile( "^\\d+$" );

    public CEPLengthParameterTextBox(HasParameterizedOperator hop,
                                     int index) {
        super( hop,
               index );
    }

    @Override
    protected boolean isValidValue(String value) {
        return VALID_LENGTH.test( value );
    }

}
