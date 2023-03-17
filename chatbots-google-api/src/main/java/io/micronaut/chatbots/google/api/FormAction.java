/*
 * Copyright 2017-2022 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.chatbots.google.api;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A form action describes the behavior when the form is submitted. For example, an Apps Script can be invoked to handle the form.
 * @see <a href="https://developers.google.com/chat/api/reference/rest/v1/cards-v1#FormAction">Form Action</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class FormAction {
    /**
     * The method name is used to identify which part of the form triggered the form submission.
     */
    @NonNull
    @NotBlank
    private String actionMethodName;

    /**
     * List of action parameters.
     */
    @Nullable
    private List<ActionParameter> parameters;

    /**
     *
     * @return The method name is used to identify which part of the form triggered the form submission.
     */
    @NonNull
    public String getActionMethodName() {
        return actionMethodName;
    }

    /**
     *
     * @param actionMethodName The method name is used to identify which part of the form triggered the form submission.
     */
    public void setActionMethodName(@NonNull String actionMethodName) {
        this.actionMethodName = actionMethodName;
    }

    /**
     *
     * @return List of action parameters.
     */
    @Nullable
    public List<ActionParameter> getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters List of action parameters.
     */
    public void setParameters(@Nullable List<ActionParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "FormAction{" +
                "actionMethodName='" + actionMethodName + '\'' +
                ", parameters=" + (parameters != null ? parameters.stream().map(ActionParameter::toString).collect(Collectors.joining(",")) : null)  +
                '}';
    }
}
