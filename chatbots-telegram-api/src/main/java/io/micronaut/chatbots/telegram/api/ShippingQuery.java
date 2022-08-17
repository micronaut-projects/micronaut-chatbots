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
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object contains information about an incoming shipping query.
 * @see <a href="https://core.telegram.org/bots/api#shippingquery">ShippingQuery</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class ShippingQuery {
    /**
     * Unique query identifier.
     */
    @NonNull
    @NotBlank
    private String id;

    /**
     * User who sent the query.
     */
    @NonNull
    @NotNull
    @Valid
    private User from;

    /**
     * Bot specified invoice payload.
     */
    @JsonProperty("invoice_payload")
    @NonNull
    @NotBlank
    private String invoicePayload;

    /**
     * User specified shipping address.
     */
    @JsonProperty("shipping_address")
    @NonNull
    @NotNull
    @Valid
    private ShippingAddress shippingAddress;

    public ShippingQuery() {
    }

    /**
     *
     * @return Unique query identifier.
     */
    @NonNull
    public String getId() {
        return id;
    }

    /**
     *
     * @param id Unique query identifier.
     */
    public void setId(@NonNull String id) {
        this.id = id;
    }

    /**
     *
     * @return User who sent the query.
     */
    @NonNull
    public User getFrom() {
        return from;
    }

    /**
     *
     * @param from User who sent the query.
     */
    public void setFrom(@NonNull User from) {
        this.from = from;
    }

    /**
     *
     * @return Bot specified invoice payload.
     */
    @NonNull
    public String getInvoicePayload() {
        return invoicePayload;
    }

    /**
     *
     * @param invoicePayload Bot specified invoice payload.
     */
    public void setInvoicePayload(@NonNull String invoicePayload) {
        this.invoicePayload = invoicePayload;
    }

    /**
     *
     * @return User specified shipping address.
     */
    @NonNull
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     *
     * @param shippingAddress User specified shipping address.
     */
    public void setShippingAddress(@NonNull ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "ShippingQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingAddress=" + (shippingAddress != null ? shippingAddress.toString() : "") +
                '}';
    }
}
