package springmvc.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springmvc.java.domain.Product;

public interface ProductDAO extends JpaRepository<Product,Long> {

	@Query("select p from Product p where p.category.categoryId = :categoryId")
	public List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);
	
	@Query("select p from Product p where p.category.categoryId = :categoryId and p.productId = :productId")
	public Product findProductByCategoryAndproductId(@Param("categoryId") Long categoryId, @Param("productId") Long productId);
}
