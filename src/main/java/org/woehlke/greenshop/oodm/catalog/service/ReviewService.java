package org.woehlke.greenshop.oodm.catalog.service;

import org.woehlke.greenshop.oodm.catalog.entities.*;
import org.woehlke.greenshop.oodm.catalog.model.ReviewProduct;
import org.woehlke.greenshop.oodm.catalog.model.WriteReviewBean;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface ReviewService {

    ReviewProduct getReviewById(long reviewId, Language language);

    List<ReviewProduct> getAllReviews(Language language);

    void update(Review review);

    ReviewDescription saveReview(WriteReviewBean writeReviewBean, Product product, Customer customer, Language language);

    List<ReviewDescription> findReviewsForProduct(ProductDescription productDescription);

    ReviewDescription findReviewById(long reviewId, Language language);

    ReviewDescription getRandomReview(Language language);
}
