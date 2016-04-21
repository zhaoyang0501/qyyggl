
package com.pzy.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pzy.entity.Pay;
import com.pzy.entity.User;
import com.pzy.repository.PayRepository;
/***
 * 
 * @author qq:263608237
 *
 */
@Service
public class PayService {
     @Autowired
     private PayRepository payRepository;

 	public List<Pay> findTop3() {
 		return payRepository.findAll(
 				new PageRequest(0, 15, new Sort(Direction.DESC, "createDate")))
 				.getContent();
 	}
     public List<Pay> findAll() {
         return (List<Pay>) payRepository.findAll(new Sort(Direction.DESC, "id"));
     }
     public Page<Pay> findAll(final int pageNumber, final int pageSize,final String name){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Pay> spec = new Specification<Pay>() {
              public Predicate toPredicate(Root<Pay> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                   predicate.getExpressions().add(cb.like(root.get("month").as(String.class), "%"+name+"%"));
              }
              return predicate;
              }
         };
         Page<Pay> result = (Page<Pay>) payRepository.findAll(spec, pageRequest);
         return result;
     	}
     
     public Page<Pay> findAll(final int pageNumber, final int pageSize,final Integer type ){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Pay> spec = new Specification<Pay>() {
              public Predicate toPredicate(Root<Pay> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (type != null) {
                  predicate.getExpressions().add(cb.equal(root.get("type").as(Integer.class),type));
               }
              return predicate;
              }
         };
         Page<Pay> result = (Page<Pay>) payRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			payRepository.delete(id);
		}
		public Pay find(Long id){
			  return payRepository.findOne(id);
		}
		public List<Pay> find(User user){
			
			  return payRepository.findByUser(user);
		}
		
		public void save(Pay pay){
			payRepository.save(pay);
		}
}