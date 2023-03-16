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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * This object contains information about an incoming pre-checkout query.
 * @see <a href="https://core.telegram.org/bots/api#precheckoutquery">PreChekoutQuery</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class PreCheckoutQuery {

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
     * Three-letter ISO 4217 currency code.
     */
    @NonNull
    @NotBlank
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @JsonProperty("total_amount")
    @NonNull
    @NotNull
    private Integer totalAmount;

    /**
     * Bot specified invoice payload.
     */
    @JsonProperty("invoice_payload")
    @NonNull
    @NotBlank
    private String invoicePayload;

    /**
     * Identifier of the shipping option chosen by the user.
     */
    @Nullable
    @JsonProperty("shipping_option_id")
    private String shippingOptionId;

    /**
     * Order info provided by the user.
     */
    @Nullable
    @Valid
    @JsonProperty("order_info")
    private OrderInfo orderInfo;

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
     * @return Three-letter ISO 4217 currency code.
     */
    @NonNull
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency Three-letter ISO 4217 currency code.
     */
    public void setCurrency(@NonNull String currency) {
        this.currency = currency;
    }

    /**
     *
     * @return Total price in the smallest units of the currency (integer, not float/double).
     */
    @NonNull
    public Integer getTotalAmount() {
        return totalAmount;
    }

    /**
     *
     * @param totalAmount Total price in the smallest units of the currency (integer, not float/double).
     */
    public void setTotalAmount(@NonNull Integer totalAmount) {
        this.totalAmount = totalAmount;
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
     * @return Identifier of the shipping option chosen by the user.
     */
    public String getShippingOptionId() {
        return shippingOptionId;
    }

    /**
     *
     * @param shippingOptionId Identifier of the shipping option chosen by the user.
     */
    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    /**
     *
     * @return Order info provided by the user.
     */
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     *
     * @param orderInfo Order info provided by the user.
     */
    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "PreCheckoutQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionId='" + shippingOptionId + '\'' +
                ", orderInfo=" + (orderInfo != null ? orderInfo.toString() : "") +
                '}';
    }
}

