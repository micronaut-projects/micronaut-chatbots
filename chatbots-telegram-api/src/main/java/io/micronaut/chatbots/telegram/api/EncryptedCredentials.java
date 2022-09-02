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

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;
import javax.validation.constraints.NotBlank;

/**
 * Contains data required for decrypting and authenticating EncryptedPassportElement. See the Telegram Passport Documentation for a complete description of the data decryption and authentication processes.
 * @see <a href="https://core.telegram.org/bots/api#encryptedcredentials">EncryptedCredentials</a>
 */
@Serdeable
public class EncryptedCredentials {

    /**
     * Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for EncryptedPassportElement decryption and authentication.
     */
    @NonNull
    @NotBlank
    private String data;

    /**
     * Base64-encoded data hash for data authentication.
     */
    @NonNull
    @NotBlank
    private String hash;

    /**
     * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption.
     */
    @NonNull
    @NotBlank
    private String secret;

    /**
     *
     * @return Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for EncryptedPassportElement decryption and authentication.
     */
    @NonNull
    public String getData() {
        return data;
    }

    /**
     *
     * @param data Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for EncryptedPassportElement decryption and authentication.
     */
    public void setData(@NonNull String data) {
        this.data = data;
    }

    /**
     *
     * @return Base64-encoded data hash for data authentication.
     */
    @NonNull
    public String getHash() {
        return hash;
    }

    /**
     *
     * @param hash Base64-encoded data hash for data authentication.
     */
    public void setHash(@NonNull String hash) {
        this.hash = hash;
    }

    /**
     *
     * @return Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    public String getSecret() {
        return secret;
    }

    /**
     *
     * @param secret Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "EncryptedCredentials{" +
                "data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
