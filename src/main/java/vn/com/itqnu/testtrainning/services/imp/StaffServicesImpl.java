package vn.com.itqnu.testtrainning.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.testtrainning.entity.Staff;
import vn.com.itqnu.testtrainning.repository.StaffRepository;
import vn.com.itqnu.testtrainning.services.StaffServices;

@Service
public class StaffServicesImpl implements StaffServices {

	private StaffRepository staffRepository;

	public StaffServicesImpl(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	@Override
	public List<Staff> getAllStaff() {

		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffById(Long id) {
		Optional<Staff> optional = staffRepository.findById(id);
		if (optional == null || optional.isPresent() == false) {
			return null;
		}
		return optional.get();
	}

	@Override
	public Staff createStaff(Staff staff) {
		Staff staff1 = new Staff();
		staff1.setUserName(staff.getUserName());
		staff1.setFullName(staff.getFullName());
		staff1.setEmail(staff.getEmail());
		staff1.setPassword(staff.getPassword());
		staff1.setPhone(staff.getPhone());
		return staffRepository.save(staff1);
	}

	@Override
	public Staff updateStaff(Long id, Staff staff) {
		Staff staff1 = getStaffById(id);
		if (staff1 == null) {
			return null;
		} else {
			staff1.setFullName(staff.getFullName());
			staff1.setEmail(staff.getEmail());
			staff1.setPassword(staff.getPassword());
			staff1.setPhone(staff.getPhone());
			return staffRepository.save(staff1);
		}
	}

	@Override
	public void deleteStaff(Long id) {
		staffRepository.deleteById(id);
	}

}
