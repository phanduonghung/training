package vn.com.itqnu.testtrainning.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.itqnu.testtrainning.entity.Staff;
import vn.com.itqnu.testtrainning.services.StaffServices;
import vn.com.itqnu.testtrainning.utils.ResponseUtil;

@RestController
@RequestMapping("/api/v1/staffs")
public class StaffControllers {

	private StaffServices staffServices;

	public StaffControllers(StaffServices staffServices) {
		this.staffServices = staffServices;
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllStaff(HttpStatus status){
		try {
			return ResponseUtil.getSuccess(staffServices.getAllStaff());
		} catch (Exception e) {
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStaffById(@PathVariable(name = "id")long id, HttpStatus status){
		try {
			return ResponseUtil.getSuccess(staffServices.getStaffById(id));
		} catch (Exception e) {
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> createStaff(@RequestBody Staff staff, HttpStatus status){
		try {
			return ResponseUtil.getSuccess(staffServices.createStaff(staff)); 
		} catch (Exception e) {
			return ResponseUtil.getError(status.BAD_REQUEST, "Staff add failed", e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStaff(@RequestBody Staff staff,@PathVariable(name = "id")long id, HttpStatus status){
		try {
			return ResponseUtil.getNormal(true, status.ACCEPTED, "Update staff successfull", "Update staff successfull", staffServices.updateStaff(id, staff));
		} catch (Exception e) {
			return ResponseUtil.getError(status.BAD_REQUEST, "Staff update don't successful", e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStaff(@PathVariable(name = "id")long id, HttpStatus status){
		try {
			staffServices.deleteStaff(id);
			return ResponseEntity.ok("Staff has been delete");
		} catch (Exception e) {
			return ResponseUtil.getError(status.BAD_REQUEST, "Delete staff don't successfull", e.getMessage());
		}
	}
	
}
