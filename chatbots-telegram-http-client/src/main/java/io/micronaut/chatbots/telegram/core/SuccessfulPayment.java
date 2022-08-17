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
package io.micronaut.chatbots.telegram.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object contains basic information about a successful payment.
 * @see <a href="https://core.telegram.org/bots/api#successfulpayment">SuccessfulPayment</a>
 */
@Serdeable
public class SuccessfulPayment {
    /**
     * Three-letter ISO 4217 currency code.
     */
    @NonNull
    @NotBlank
    private String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @NonNull
    @NotNull
    @JsonProperty("total_amount")
    private Integer totalAmount;

    /**
     * Bot specified invoice payload.
     */
    @NonNull
    @NotBlank
    @JsonProperty("invoice_payload")
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
    @JsonProperty("order_info")
    @Valid
    private OrderInfo orderInfo;

    /**
     * Telegram payment identifier.
     */
    @NonNull
    @NotBlank
    @JsonProperty("telegram_payment_charge_id")
    private String telegramPaymentChargeId;

    /**
     * Provider payment identifier.
     */
    @NonNull
    @NotBlank
    @JsonProperty("provider_payment_charge_id")
    private String providerPaymentChargeId;

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
    @Nullable
    public String getShippingOptionId() {
        return shippingOptionId;
    }

    /**
     *
     * @param shippingOptionId Identifier of the shipping option chosen by the user.
     */
    public void setShippingOptionId(@Nullable String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    /**
     *
     * @return Order info provided by the user.
     */
    @Nullable
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     *
     * @param orderInfo Order info provided by the user.
     */
    public void setOrderInfo(@Nullable OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    /**
     *
     * @return Telegram payment identifier.
     */
    @NonNull
    public String getTelegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    /**
     *
     * @param telegramPaymentChargeId Telegram payment identifier.
     */
    public void setTelegramPaymentChargeId(@NonNull String telegramPaymentChargeId) {
        this.telegramPaymentChargeId = telegramPaymentChargeId;
    }

    /**
     *
     * @return Provider payment identifier.
     */
    @NonNull
    public String getProviderPaymentChargeId() {
        return providerPaymentChargeId;
    }

    /**
     *
     * @param providerPaymentChargeId Provider payment identifier.
     */
    public void setProviderPaymentChargeId(@NonNull String providerPaymentChargeId) {
        this.providerPaymentChargeId = providerPaymentChargeId;
    }

    @Override
    public String toString() {
        return "SuccessfulPayment{" +
                "currency='" + currency + '\'' +
                ", totalAmount=" + totalAmount +
                ", invoicePayload='" + invoicePayload + '\'' +
                ", shippingOptionId='" + shippingOptionId + '\'' +
                ", orderInfo=" + (orderInfo != null ? orderInfo.toString() : "") +
                ", telegramPaymentChargeId='" + telegramPaymentChargeId + '\'' +
                ", providerPaymentChargeId='" + providerPaymentChargeId + '\'' +
                '}';
    }
}
