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
package io.micronaut.chatbots.telegram.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

/**
 * This object represents a shipping address.
 * @see <a href="https://core.telegram.org/bots/api#shippingaddress">Shipping Address</a>
 */
@Serdeable
public class ShippingAddress {

    /**
     * ISO 3166-1 alpha-2 country code.
     */
    @JsonProperty("country_code")
    @NonNull
    @NotBlank
    private String countryCode;

    /**
     * State, if applicable.
     */
    @NonNull
    @NotBlank
    private String state;

    /**
     * City.
     */
    @NonNull
    @NotBlank
    private String city;

    /**
     * First line for the address.
     */
    @NonNull
    @NotBlank
    @JsonProperty("street_line1")
    private String streetLine1;

    /**
     * Second line for the address.
     */
    @NonNull
    @NotBlank
    @JsonProperty("street_line2")
    private String streetLine2;

    /**
     * Address post codes.
     */
    @NonNull
    @NotBlank
    @JsonProperty("post_code")
    private String postCode;

    public ShippingAddress() {
    }

    /**
     *
     * @return ISO 3166-1 alpha-2 country code.
     */
    @NonNull
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @param countryCode ISO 3166-1 alpha-2 country code.
     */
    public void setCountryCode(@NonNull String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     * @return State, if applicable.
     */
    @NonNull
    public String getState() {
        return state;
    }

    /**
     *
     * @param state State, if applicable.
     */
    public void setState(@NonNull String state) {
        this.state = state;
    }

    /**
     *
     * @return City.
     */
    @NonNull
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city City.
     */
    public void setCity(@NonNull String city) {
        this.city = city;
    }

    /**
     *
     * @return First line for the address.
     */
    @NonNull
    public String getStreetLine1() {
        return streetLine1;
    }

    /**
     *
     * @param streetLine1 First line for the address.
     */
    public void setStreetLine1(@NonNull String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    /**
     *
     * @return Second line for the address.
     */
    @NonNull
    public String getStreetLine2() {
        return streetLine2;
    }

    /**
     *
     * @param streetLine2 Second line for the address.
     */
    public void setStreetLine2(@NonNull String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    /**
     *
     * @return Address post codes.
     */
    @NonNull
    public String getPostCode() {
        return postCode;
    }

    /**
     *
     * @param postCode Address post codes.
     */
    public void setPostCode(@NonNull String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "countryCode='" + countryCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", streetLine1='" + streetLine1 + '\'' +
                ", streetLine2='" + streetLine2 + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
