package com.kb.merco.journal.service.patch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.stereotype.Component;

/**
 * This method handles the patching operation.
 *
 * @param <T> This is target object to apply patch on.
 * @param <V> This is the patch document for the operation
 * @author shubham lokhande
 * @version 1.0
 * @since 1.0
 */
@Component
public class JsonPatchMapper<T, V> {
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * This method handles replacing fields in the Target object based on the patch document
     *
     * @param target           The target object on which patch has to be applied on.
     * @param patchDocumentDto The patch document that gives the deatils of the operation to be performed.
     * @param clazz            This is the .class of the Target object.
     * @return This gives the patched object.
     * @throws JsonPatchException
     * @throws JsonProcessingException
     */
    public T replace(T target, V patchDocumentDto, Class<T> clazz) throws JsonPatchException, JsonProcessingException {
        T updated = null;
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //patchdocument is written in string[JSON format] whose fields are mapped to patch and copied
        //Refer to Objectmapper documentation online --->google it
        JsonPatch patch = mapper.readValue(mapper.writeValueAsString(patchDocumentDto), JsonPatch.class);

        //JsonNode object of target is created and the patch is applied to it
        JsonNode patched = patch.apply(mapper.convertValue(target, JsonNode.class));

        //Using this JsonNode we map and copy it to updated
        updated = mapper.treeToValue(patched, clazz);

        return updated;
    }

}
