/*
 * Copyright 2017-2021 original authors
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
package io.micronaut.chatbots.telegram.api.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class SendContact extends Send  {

    /**
     * Contact's phone number.
     */
    @JsonProperty("phone_number")
    @NotBlank
    @NonNull
    private String phoneNumber;

    /**
     * Contact's first name.
     */
    @JsonProperty("first_name")
    @NotBlank
    @NonNull
    private String firstName;

    /**
     * Contact's last name.
     */
    @JsonProperty("last_name")
    @Nullable
    private String lastName;

    /**
     * Additional data about the contact in the form of a vCard, 0-2048 bytes.
     */
    @Nullable
    private String vcard;

    public SendContact() {
        super("sendContact");
    }

    /**
     *
     * @return Contact's phone number.
     */
    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber Contact's phone number.
     */
    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return Contact's first name.
     */
    @NonNull
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName Contact's first name.
     */
    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return Contact's last name.
     */
    @Nullable
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName Contact's last name.
     */
    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return Additional data about the contact in the form of a vCard, 0-2048 bytes.
     */
    @Nullable
    public String getVcard() {
        return vcard;
    }

    /**
     *
     * @param vcard Additional data about the contact in the form of a vCard, 0-2048 bytes.
     */
    public void setVcard(@Nullable String vcard) {
        this.vcard = vcard;
    }
}
