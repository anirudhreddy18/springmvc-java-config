package springmvc.java.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import springmvc.java.domain.Category;


public interface CategoryDAO extends CrudRepository<Category,Long> {

	@Query("select c from Category c where c.categoryName = :categoryName")
	Category findByCategoryName(@Param("categoryName") String categoryName);
}
