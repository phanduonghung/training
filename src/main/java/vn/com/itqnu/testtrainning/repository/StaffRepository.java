package vn.com.itqnu.testtrainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.testtrainning.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}
