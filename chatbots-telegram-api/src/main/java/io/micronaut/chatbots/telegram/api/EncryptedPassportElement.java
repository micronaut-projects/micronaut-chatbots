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
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://core.telegram.org/bots/api#encryptedpassportelement">EncryptedPassportElement</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Serdeable
public class EncryptedPassportElement {

    /**
     * Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
     */
    @NonNull
    @NotBlank
    @Pattern(regexp = "personal_details|passport|driver_license|identity_card|internal_passport|address|utility_bill|bank_statement|rental_agreement|passport_registration|temporary_registration|phone_number|email")
    private String type;

    /**
     * Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private String data;

    /**
     * User's verified phone number, available only for “phone_number” type.
      */
    @Nullable
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * User's verified email address, available only for “email” type.
     */
    @Nullable
    private String email;

    /**
     * Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private List<PassportFile> files;

    /**
     * Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
      */
    @Nullable
    @JsonProperty("front_side")
    private PassportFile frontSide;

    /**
     * Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    @JsonProperty("reverse_side")
    private PassportFile reverseSide;

    /**
     * Optional. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private PassportFile selfie;

    /**
     * Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private List<PassportFile> translation;

    /**
     * Base64-encoded element hash for using in PassportElementErrorUnspecified.
     */
    @NotBlank
    @NonNull
    private String hash;

    /**
     *
     * @return Element type
     */
    @NonNull
    public String getType() {
        return type;
    }

    /**
     *
     * @param type Element type
     */
    public void setType(@NonNull String type) {
        this.type = type;
    }

    /**
     *
     * @return Base64-encoded encrypted Telegram Passport element data provided by the user
     */
    @Nullable
    public String getData() {
        return data;
    }

    /**
     *
     * @param data Base64-encoded encrypted Telegram Passport element data provided by the user
     */
    public void setData(@Nullable String data) {
        this.data = data;
    }

    /**
     *
     * @return User's verified phone number, available only for “phone_number” type.
     */
    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber User's verified phone number, available only for “phone_number” type
     */
    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return User's verified email address, available only for “email” type.
     */
    @Nullable
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email User's verified email address, available only for “email” type.
     */
    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    /**
     *
     * @return List of encrypted files with documents provided by the user
     */
    @Nullable
    public List<PassportFile> getFiles() {
        return files;
    }

    /**
     *
     * @param files Array of encrypted files with documents provided by the user
     */
    public void setFiles(@Nullable List<PassportFile> files) {
        this.files = files;
    }

    /**
     *
     * @return Encrypted file with the front side of the document, provided by the user.
     */
    @Nullable
    public PassportFile getFrontSide() {
        return frontSide;
    }

    /**
     *
     * @param frontSide Encrypted file with the front side of the document, provided by the user.
     */
    public void setFrontSide(@Nullable PassportFile frontSide) {
        this.frontSide = frontSide;
    }

    /**
     *
     * @return Encrypted file with the reverse side of the document, provided by the user.
     */
    @Nullable
    public PassportFile getReverseSide() {
        return reverseSide;
    }

    /**
     *
     * @param reverseSide Encrypted file with the reverse side of the document, provided by the user.
     */
    public void setReverseSide(@Nullable PassportFile reverseSide) {
        this.reverseSide = reverseSide;
    }

    /**
     *
     * @return Encrypted file with the selfie of the user holding a document, provided by the user;
     */
    @Nullable
    public PassportFile getSelfie() {
        return selfie;
    }

    /**
     *
     * @param selfie Encrypted file with the selfie of the user holding a document, provided by the user;
     */
    public void setSelfie(@Nullable PassportFile selfie) {
        this.selfie = selfie;
    }

    /**
     *
     * @return List of encrypted files with translated versions of documents provided by the user.
     */
    @Nullable
    public List<PassportFile> getTranslation() {
        return translation;
    }

    /**
     *
     * @param translation Array of encrypted files with translated versions of documents provided by the user.
     */
    public void setTranslation(@Nullable List<PassportFile> translation) {
        this.translation = translation;
    }

    /**
     *
     * @return Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    @NonNull
    public String getHash() {
        return hash;
    }

    /**
     *
     * @param hash Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    public void setHash(@NonNull String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "EncryptedPassportElement{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", files=" + files +
                ", files=" + (files != null ? files.stream().map(PassportFile::toString).collect(Collectors.joining(",")) : "") +
                ", frontSide=" + (frontSide != null ? frontSide.toString() : "") +
                ", reverseSide=" + (reverseSide != null ? reverseSide.toString() : "") +
                ", selfie=" + (selfie != null ? selfie.toString() : "") +
                ", translation=" + (translation != null ? translation.stream().map(PassportFile::toString).collect(Collectors.joining(",")) : "") +

                ", hash='" + hash + '\'' +
                '}';
    }
}
