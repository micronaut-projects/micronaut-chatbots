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
package io.micronaut.chatbots.telegram.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

/**
 * This object represents information about an order.
 * @see <a href="https://core.telegram.org/bots/api#orderinfo">OrderInfo</a>
 */
@Serdeable
public class OrderInfo {

    /**
     * User name.
     */
    @Nullable
    private String name;

    /**
     * User's phone number.
     */
    @Nullable
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * User email.
     */
    @Nullable
    private String email;

    /**
     * User shipping address.
     */
    @Nullable
    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    public OrderInfo() {
    }

    /**
     *
     * @return User name.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     *
     * @param name User name.
     */
    public void setName(@Nullable String name) {
        this.name = name;
    }

    /**
     *
     * @return User's phone number.
     */
    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber User's phone number.
     */
    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return User email.
     */
    @Nullable
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email User email.
     */
    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    /**
     *
     * @return User shipping address.
     */
    @Nullable
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     *
     * @param shippingAddress User shipping address.
     */
    public void setShippingAddress(@Nullable ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", shippingAddress=" + (shippingAddress != null ? shippingAddress.toString() : "") +
                '}';
    }
}
