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
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * List of string parameters to supply when the action method is invoked. For example, consider three snooze buttons: snooze now, snooze 1 day, snooze next week. You might use action method = snooze(), passing the snooze type and snooze time in the list of string parameters.
 * @see <a href="https://developers.google.com/chat/api/reference/rest/v1/cards-v1#ActionParameter">ActionParameter</a>.
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class ActionParameter {

    /**
     * The name of the parameter for the action script.
     */
    @NonNull
    @NotBlank
    private String key;

    /**
     * The value of the parameter.
     */
    @NonNull
    @NotBlank
    private String value;

    /**
     *
     * @return The name of the parameter for the action script.
     */
    @NonNull
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key The name of the parameter for the action script.
     */
    public void setKey(@NonNull String key) {
        this.key = key;
    }

    /**
     *
     * @return The value of the parameter.
     */
    @NonNull
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value The value of the parameter.
     */
    public void setValue(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ActionParameter{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
