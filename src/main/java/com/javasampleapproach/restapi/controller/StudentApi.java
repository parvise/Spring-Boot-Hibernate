package com.javasampleapproach.restapi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javasampleapproach.restapi.model.MaterialTable;
import com.javasampleapproach.restapi.model.SkillSet;
import com.javasampleapproach.restapi.model.Skills;
import com.javasampleapproach.restapi.model.Student;
import com.javasampleapproach.restapi.pojo.MaterialTableBean;
import com.javasampleapproach.restapi.pojo.SkillsBean;
import com.javasampleapproach.restapi.pojo.StudentBean;
import com.javasampleapproach.restapi.service.MaterialTableService;
import com.javasampleapproach.restapi.service.SkillSetService;
import com.javasampleapproach.restapi.service.StudentService;
import com.javasampleapproach.restapi.service.StudentSkillsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentApi {

	@Autowired
	public StudentService service;

	@Autowired
	public SkillSetService skillService;

	@Autowired
	public StudentSkillsService studentSkillService;

	@Autowired
	private MaterialTableService materialTableService;

	@Autowired
	private DataSource datasource;

	@PostMapping(value = "/add/students")
	public StudentBean saveSudent(@RequestBody StudentBean student) {
		System.out.println("Before" + student);
		Student dbStudent = convertBeanToEntity(student);

		System.out.println("After" + dbStudent);
		Student updateStudent = service.saveStudent(dbStudent);

		// studentSkillService.addStudentSkills(dbStudent.getSkills());

		StudentBean newBean = convertEntityToBean(updateStudent);
		System.out.println("---" + newBean);
		return newBean;

	}

	@GetMapping(value = "/get/students")
	public List<StudentBean> getStudents() {
		List<Student> list = service.getStudentList();
		System.out.println(list);

		List<StudentBean> newList = new ArrayList<>();
		for (Student student : list) {
			newList.add(convertEntityToBean(student));
		}
		System.out.println(newList);
		return newList;
	}

	@GetMapping(value = "/edit/students/{id}")
	public StudentBean getStudentById(@PathVariable int id) {
		System.out.println("Get By Id" + id);
		StudentBean bean = convertEntityToBean(service.getStudent(id).get());
		System.out.println("GEt--" + bean);
		return bean;
	}

	@PutMapping(value = "/update/students/{id}")
	public StudentBean updateStudent(@PathVariable int id, @RequestBody StudentBean student) {
		try {
			System.out.println("Update" + student);
			Student dbData = service.getStudent(id).get();
			if (dbData != null) {
				System.out.println(dbData);
				Student uiPojo = convertBeanToEntity(student);
				System.out.println("uiPojo" + uiPojo);
				Student data = service.saveStudent(uiPojo);
				// List<Skills> skillList =
				// studentSkillService.addStudentSkills(uiPojo.getSkills());
				return convertEntityToBean(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DeleteMapping(value = "/delete/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		System.out.println("Delete" + id);
		Student dbData = service.getStudent(id).get();
		if (dbData != null) {
			service.deleteStudent(dbData);
		}
	}

	@GetMapping(value = "/add/skillsets")
	public List<SkillSet> saveSkillSets() {
		List<SkillSet> list = new ArrayList<>();

		list.add(new SkillSet(1, "Java/J2EE"));
		list.add(new SkillSet(2, "Angular"));
		list.add(new SkillSet(3, "C"));
		list.add(new SkillSet(4, "C++"));
		list.add(new SkillSet(5, "Haddoop"));
		list.add(new SkillSet(6, "Python"));
		list.add(new SkillSet(7, ".Net"));
		list.add(new SkillSet(8, "C#"));

		return skillService.addSkillSet(list);
	}

	@GetMapping(value = "/get/skillsets")
	public List<SkillSet> fetchSkillSets() {

		return skillService.fetchSkillSet();
	}

	@GetMapping(value = "/dummy")
	public Student dummyStudents() {

		Student student = new Student();
		student.setFullName("Pervez");
		student.setEmail("p@hp.com");
		student.setContactPrefer("email");

		Skills s1 = new Skills();
		s1.setSkillName("Java/J2EE");
		s1.setExperience(7);
		s1.setProficeincy("expert");
		// s1.setStudent(student);

		Skills s2 = new Skills();
		s2.setSkillName("Angular");
		s2.setExperience(1);
		s2.setProficeincy("expert");
		// s2.setStudent(student);

		student.getSkills().add(s1);
		student.getSkills().add(s2);
		// return studentSkillService.addStudentSkills(skills);
		studentSkillService.addStudentSkills(student.getSkills());
		Student save = service.saveStudent(student);
		return null;
	}

	private Student convertBeanToEntity(StudentBean student) {
		Student dbStudent = new Student();
		dbStudent.setId(student.getId());
		dbStudent.setEmail(student.getEmail());
		dbStudent.setContactPrefer(student.getContactPrefer());
		dbStudent.setFullName(student.getFullName());
		dbStudent.setPhone(student.getPhone());
		Collection<SkillsBean> skillSet = student.getSkills();
		Collection<Skills> skills = new ArrayList<>();
		for (SkillsBean skill : skillSet) {
			Skills skillEntity = new Skills();
			skillEntity.setSkillId(skill.getSkillId());
			skillEntity.setSkillName(skill.getSkillName());
			skillEntity.setExperience(skill.getExperience());
			skillEntity.setProficeincy(skill.getProficeincy());
			// skillEntity.setStudent(dbStudent);
			skills.add(skillEntity);
		}
		dbStudent.setSkills(skills);
		return dbStudent;
	}

	private StudentBean convertEntityToBean(Student student) {
		StudentBean bean = new StudentBean();
		bean.setId(student.getId());
		bean.setContactPrefer(student.getContactPrefer());
		bean.setEmail(student.getEmail());
		bean.setFullName(student.getFullName());
		bean.setPhone(student.getPhone());

		List<SkillsBean> list = new ArrayList<>();
		for (Skills skillsBean : student.getSkills()) {
			SkillsBean skills = new SkillsBean();
			skills.setSkillId(skillsBean.getSkillId());
			skills.setSkillName(skillsBean.getSkillName());
			skills.setExperience(skillsBean.getExperience());
			skills.setProficeincy(skillsBean.getProficeincy());
			list.add(skills);
		}

		bean.setSkills(list);

		return bean;
	}

	@PostMapping(value = "/save/materialdata")
	public MaterialTableBean saveMaterial(@RequestBody MaterialTableBean matBean) {
		MaterialTable matTable = materialTableService.save(convertBeanToEntity(matBean));
		System.out.println("users->" + matTable);
		return convertEntityToBean(matTable);
	}

	@PutMapping(value = "/update/materialdata")
	public MaterialTableBean updateMaterial(@RequestBody MaterialTableBean matBean) {
		MaterialTable dbData = materialTableService.findById(matBean.getId());
		MaterialTable uiData = convertBeanToEntity(matBean);
		uiData.setUploadFile(dbData.getUploadFile());
		uiData.setFileName(dbData.getFileName());
		MaterialTable matTable = materialTableService.save(uiData);

		System.out.println("users->" + matTable);
		return convertEntityToBean(matTable);
	}

	@DeleteMapping(value = "/delete/materialdata/{id}")
	public void deleteMaterialTable(@PathVariable int id) {
		System.out.println("Delete" + id);
		MaterialTable dbData = materialTableService.findById(id);
		if (dbData != null) {
			materialTableService.deleteData(dbData);
		}
	}

	@GetMapping(value = "/get/materialdata")
	public List<MaterialTable> getMatData(Principal principal) {
		System.out.println("Principal" + principal);
		System.out.println("getMatData" + datasource);
		return materialTableService.getData();
	}

	private MaterialTable convertBeanToEntity(MaterialTableBean student) {
		MaterialTable bean = new MaterialTable();
		bean.setId(student.getId());
		bean.setEmail(student.getEmail());
		bean.setFullName(student.getFullName());
		bean.setHireDate(student.getHireDate());
		bean.setPermanent(student.isPermanent());
		bean.setDepartment(student.getDepartment());
		bean.setGender(student.getGender());

		/*
		 * Blob b1; try { b1 = datasource.getConnection().createBlob();
		 * b1.setBytes(1, student.getUplodaFile().getBytes());
		 * bean.setUplodaFile(b1); } catch (Exception e) { e.printStackTrace();
		 * }
		 */

		System.out.println("convertBeanToEntity" + datasource);

		return bean;
	}

	private MaterialTableBean convertEntityToBean(MaterialTable student) {
		MaterialTableBean bean = new MaterialTableBean();
		bean.setId(student.getId());
		bean.setEmail(student.getEmail());
		bean.setFullName(student.getFullName());
		bean.setHireDate(student.getHireDate());
		bean.setPermanent(student.isPermanent());
		bean.setDepartment(student.getDepartment());
		bean.setGender(student.getGender());
		bean.setFileName(student.getFileName());
		System.out.println("convertEntityToBean" + datasource);
		return bean;
	}

	@PostMapping("/upload/file")
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("customer") String text) {
		try {
			System.out.println("file" + file);
			MaterialTable dbData = materialTableService.findById(Integer.parseInt(text));
			System.out.println(dbData.getFileName() + "********");
			File dir = new File("E:/Angular/Angular-6-Http-Client/Angular-6-Http-Client/src/assets/images");
			if (dbData.getFileName() != null) {
				File deleteFile = new File(dir.getAbsolutePath() + File.separator + dbData.getFileName());
				System.out.println("test" + deleteFile.getAbsolutePath());
				deleteFile.delete();
			}

			dbData.setUploadFile(file.getBytes());
			dbData.setFileName(file.getOriginalFilename());
			materialTableService.save(dbData);

			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");

				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				String filePath = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
				System.out.println("filePath:" + filePath);
				File serverFile = new File(filePath);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location=" + serverFile.getAbsolutePath());
			}
			System.out.println(text);
			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}

	@GetMapping("/download/file/{id}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {
		MaterialTable fileOptional = materialTableService.findById(id);

		if (fileOptional != null) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=\"" + fileOptional.getFileName() + "\"")
					.body(fileOptional.getUploadFile());
		}

		return ResponseEntity.status(404).body(null);
	}

}
