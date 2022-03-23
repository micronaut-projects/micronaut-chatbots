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
package io.micronaut.chatbots.telegram.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * This object represents a phone contact.
 * @see <a href="https://core.telegram.org/bots/api#contact">This object represents a phone contact.</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    /**
     * Contact's phone number.
     */
    @JsonProperty("phone_number")
    @NonNull
    @NotBlank
    private String phoneNumber;

    /**
     * Contact's first name.
     */
    @NonNull
    @NotBlank
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Contact's last name.
     */
    @Nullable
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Contact's user identifier in Telegram.
     */
    @Nullable
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * Additional data about the contact in the form of a vCard.
     */
    @Nullable
    private String vcard;

    public Contact() {
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
     * @return Contact's user identifier in Telegram
     */
    @Nullable
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId Contact's user identifier in Telegram
     */
    public void setUserId(@Nullable Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @return Additional data about the contact in the form of a vCard.
     */
    @Nullable
    public String getVcard() {
        return vcard;
    }

    /**
     *
     * @param vcard Additional data about the contact in the form of a vCard.
     */
    public void setVcard(@Nullable String vcard) {
        this.vcard = vcard;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId=" + userId +
                ", vcard='" + vcard + '\'' +
                '}';
    }
}
