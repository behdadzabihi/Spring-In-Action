package org.spring.in.action.spring.in.action.dao;

import org.spring.in.action.spring.in.action.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
         extends CrudRepository<TacoOrder, Long> {

//  List<TacoOrder> findByUserOrderByPlacedAtDesc(
//          User user, Pageable pageable);


}
