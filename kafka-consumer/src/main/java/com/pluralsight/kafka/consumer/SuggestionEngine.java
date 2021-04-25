package com.pluralsight.kafka.consumer;

import com.example.kafka.model.Product;
import com.example.kafka.model.User;
import com.pluralsight.kafka.consumer.domain.InternalUser;
import com.pluralsight.kafka.consumer.domain.PreferredProduct;
import com.pluralsight.kafka.consumer.service.UserDB;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class SuggestionEngine {

    private UserDB userDB = new UserDB();

    public void processSuggestions(User user, Product product) {
        log.info(String.format(
                "Thread: %s => InternalUser with ID: %s showed interest over %s of color %s and design %s",
                Thread.currentThread().getName(),
                user.getUserId(),
                product.getProductType(),
                product.getColor(),
                product.getDesignType()));

        // Retrieve preferences from Database
        InternalUser internalUser = userDB.findByID(user.getUserId().toString());

        // Update internalUser preferences
        internalUser.getPreferences()
                .add(new PreferredProduct(product.getColor().toString(), product.getProductType().toString(), product.getDesignType().toString()));

        // Generate list of suggestions
        internalUser.setSuggestions(generateSugestions(internalUser.getPreferences()));

        // Store the suggestions in the database / send them to a kafka topic
        userDB.save(internalUser);
    }

    /**
     * @return hardcoded suggestions
     */
    private List<String> generateSugestions(List<PreferredProduct> preferences) {
        return Arrays.asList("TSHIRT,BLUE",
                "DESIGN,ORANGE,ROCKET",
                "TSHIRT,PURPLE,CAR");
    }

}
