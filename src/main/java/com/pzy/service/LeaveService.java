
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

import com.pzy.entity.Leave;
import com.pzy.entity.User;
import com.pzy.repository.LeaveRepository;
/***
 * 
 * @author qq:263608237
 *
 */
@Service
public class LeaveService {
     @Autowired
     private LeaveRepository leaveRepository;

 	public List<Leave> findTop3() {
 		return leaveRepository.findAll(
 				new PageRequest(0, 15, new Sort(Direction.DESC, "createDate")))
 				.getContent();
 	}
     public List<Leave> findAll() {
         return (List<Leave>) leaveRepository.findAll(new Sort(Direction.DESC, "id"));
     } 
     
     public List<Leave> findByUser(User user) {
         return (List<Leave>) leaveRepository.findByUser(user);
     }
     public Page<Leave> findAll(final int pageNumber, final int pageSize,final String name){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Leave> spec = new Specification<Leave>() {
              public Predicate toPredicate(Root<Leave> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                   predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%"+name+"%"));
              }
              return predicate;
              }
         };
         Page<Leave> result = (Page<Leave>) leaveRepository.findAll(spec, pageRequest);
         return result;
     	}
     
     public Page<Leave> findAll(final int pageNumber, final int pageSize,final Integer type ){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Leave> spec = new Specification<Leave>() {
              public Predicate toPredicate(Root<Leave> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (type != null) {
                  predicate.getExpressions().add(cb.equal(root.get("type").as(Integer.class),type));
               }
              return predicate;
              }
         };
         Page<Leave> result = (Page<Leave>) leaveRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			leaveRepository.delete(id);
		}
		public Leave find(Long id){
			  return leaveRepository.findOne(id);
		}
		public void save(Leave leave){
			leaveRepository.save(leave);
		}
}