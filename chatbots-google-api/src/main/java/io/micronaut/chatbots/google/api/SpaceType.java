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

/**
 * @see <a href="https://developers.google.com/chat/api/reference/rest/v1/spaces#Space.SpaceType">Space Type</a>
 * @author Sergio del Amo
 * @since 1.0.0
 */
public enum SpaceType {
    /**
     * Reserved.
     */
    SPACE_TYPE_UNSPECIFIED,

    /**
     * A place where people send messages, share files, and collaborate. A SPACE can include Chat apps.
     */
    SPACE,
    /**
     * Group conversations between 3 or more people. A GROUP_CHAT can include Chat apps.
     */
    GROUP_CHAT,

    /**
     * 1:1 messages between two humans or a human and a Chat app.
     */
    DIRECT_MESSAGE;
}
