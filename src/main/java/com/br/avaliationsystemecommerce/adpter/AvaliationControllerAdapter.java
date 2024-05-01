package com.br.avaliationsystemecommerce.adpter;


import com.br.avaliationsystemecommerce.dto.AvaliationAverageOutput;
import com.br.avaliationsystemecommerce.dto.AvaliationCommentsOutput;
import com.br.avaliationsystemecommerce.dto.AvaliationRequest;
import com.br.avaliationsystemecommerce.port.AvaliationControllerPort;
import com.br.avaliationsystemecommerce.service.AvaliationServicePersistence;
import com.br.avaliationsystemecommerce.service.AvaliationServiceReading;
import com.br.avaliationsystemecommerce.utils.exceptions.ProductCommentRetrievalException;
import io.micrometer.core.annotation.Timed;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/avaliations")
@AllArgsConstructor
public class AvaliationControllerAdapter implements AvaliationControllerPort {

    private AvaliationServicePersistence avaliationServicePersistence;
    private AvaliationServiceReading avaliationServiceReading;

    @Override
    @Timed(value = "avaliation.createAvaliation", description = "Tempo de resposta do POST createAvaliation")
    public ResponseEntity<?> createAvaliation(AvaliationRequest avaliationRequest) {
        log.info("Creating a new avaliation for product {}", avaliationRequest.productId());
        avaliationServicePersistence.createAvaliation(avaliationRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    @Timed(value = "avaliation.getCommentsProduct", description = "Tempo de resposta do GET getCommentsProduct")
    public ResponseEntity<AvaliationCommentsOutput> getCommentsProduct(
            @PathVariable Long productId,
            @RequestParam(name = "page", defaultValue = "0", required = false) @Min(0) Integer page
    ) throws ProductCommentRetrievalException {
        log.info("Getting comments for product {}", productId);
        AvaliationCommentsOutput comments = avaliationServiceReading.getCommentsProduct(productId, page);
        return ResponseEntity.ok(comments);
    }

    @Override
    @Timed(value = "avaliation.getAverageProduct", description = "Tempo de resposta do GET getAverageProduct")
    public ResponseEntity<AvaliationAverageOutput> getAverageProduct(Long productId) {
        log.info("Getting average for product {}", productId);
        AvaliationAverageOutput response = avaliationServiceReading.getAverageProduct(productId);
        return ResponseEntity.ok(response);
    }
}
