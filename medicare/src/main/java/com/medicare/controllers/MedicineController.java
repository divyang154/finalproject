package com.medicare.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medicare.dto.MedicineDto;
import com.medicare.forms.MedicineForm;
import com.medicare.service.MedicineService;

@Controller
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	private static final String addMedicineForm = "addMedicineForm";
	private static final int activate = 0;
	private static final int deactivate = 1;

	@RequestMapping(value = { "/loadMedicine" })
	public ModelAndView loadMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		System.out.println("Model View:-" + medicineForm);
		modelView.setViewName("addMedicine");
		return modelView;
	}

	@RequestMapping(value = { "/showAllMedicine" })
	public ModelAndView showAllMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDto();
		modelView.setViewName("showAllMedicine");
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("medicineForm", medicineForm);
		return modelView;
	}

	@RequestMapping(value = { "/addMedicine" })
	public ModelAndView addMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		MedicineDto medicineDto = convertToMedicineDto(medicineForm);
		medicineService.insertMedicine(medicineDto);
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDto();
		modelView.setViewName("showAllMedicine");
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("medicineForm", medicineForm);
		return modelView;
	}

	@RequestMapping(value = { "/editMedicine" })
	public ModelAndView editMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		List<MedicineDto> medicineDtoLis = medicineService.getMedicineDto(medicineForm.getMedicineId());
		modelView.setViewName("editMedicine");
		modelView.addObject("medicineForm", convertToMedicineForm(medicineDtoLis.get(0)));
		return modelView;
	}

	@RequestMapping(value = { "/updateMedicine" })
	public ModelAndView updateMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		medicineService.updateMedicine(convertToMedicineDto(medicineForm));
		modelView.setViewName("showAllMedicine");
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDto();
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("medicineForm", medicineForm);
		return modelView;
	}

	@RequestMapping(value = { "/deleteMedicine" })
	public ModelAndView deleteMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		medicineService.deleteMedicineDto(medicineForm.getMedicineId());
		modelView.setViewName("showAllMedicine");
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDto();
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("medicineForm", medicineForm);
		return modelView;
	}

	@RequestMapping(value = { "/changeStatusEnable" })
	public ModelAndView changeStatus(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		medicineForm.setStatus(activate);
		medicineService.updateMedicineDtoStatus(medicineForm.getMedicineId(), medicineForm.getStatus());
		modelView.setViewName("showAllMedicine");
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDto();
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("medicineForm", medicineForm);
		return modelView;
	}

	@RequestMapping(value = { "/changeStatusDisable" })
	public ModelAndView changeStatusDisable(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		medicineForm.setStatus(deactivate);
		medicineService.updateMedicineDtoStatus(medicineForm.getMedicineId(), medicineForm.getStatus());
		modelView.setViewName("showAllMedicine");
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDto();
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("medicineForm", medicineForm);
		return modelView;
	}

	@RequestMapping(value = { "/selectedMedicineList" })
	public ModelAndView selectedMedicineList(@RequestParam("checkboxName") String[] checkboxValue,
			HttpSession session) {
		session.setAttribute("selectedInt", checkboxValue);
		ModelAndView modelView = new ModelAndView();
		List<MedicineDto> medicineDtoList = medicineService.getAllMedicineDtoById(checkboxValue);
		MedicineForm medicineForm = new MedicineForm();
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("addMedicineForm", medicineForm);
		modelView.setViewName("PurchasedList");
		return modelView;
	}

	@RequestMapping(value = { "/makePayment" })
	public ModelAndView makePayment() {
		ModelAndView modelView = new ModelAndView();
		MedicineForm medicineForm = new MedicineForm();
		modelView.addObject("addMedicineForm", medicineForm);
		modelView.setViewName("MakePayment");
		return modelView;
	}
	
	@RequestMapping(value = { "/sortByPrice" })
	public ModelAndView sortByPrice(@ModelAttribute(addMedicineForm) MedicineForm medicineForm) {
		ModelAndView modelView = new ModelAndView();
		List<MedicineDto> medicineDtoList = medicineService.getAllActiveMedicineDto();
		modelView.setViewName("UserPurchaseList");
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("addMedicineForm", medicineForm);
		return modelView;
	}
	
	@RequestMapping(value = { "/searchMedicine" })
	public ModelAndView searchMedicine(@ModelAttribute(addMedicineForm) MedicineForm medicineForm,@RequestParam("medicineName") String medicineName) {
		ModelAndView modelView = new ModelAndView();
		List<MedicineDto> medicineDtoList = medicineService.getAllActiveMedicineDto();
		medicineDtoList=medicineDtoList.stream().filter(medicineDto -> medicineDto.getMedicineName().contains(medicineName)).collect(Collectors.toList());
		modelView.setViewName("UserPurchaseList");
		Collections.sort(medicineDtoList);
		medicineForm.setMedicineDtoList(medicineDtoList);
		modelView.addObject("addMedicineForm", medicineForm);
		return modelView;
	}

	MedicineDto convertToMedicineDto(MedicineForm medicineForm) {
		MedicineDto medicineDto = new MedicineDto();
		medicineDto.setMedicineDescription(medicineForm.getMedicineDescription());
		medicineDto.setMedicineName(medicineForm.getMedicineName());
		medicineDto.setMedicinePrice(medicineForm.getMedicinePrice());
		medicineDto.setMedicineSeller(medicineForm.getMedicineSeller());
		medicineDto.setMedicineId(medicineForm.getMedicineId());
		return medicineDto;
	}

	MedicineForm convertToMedicineForm(MedicineDto medicineDto) {
		MedicineForm medicineForm = new MedicineForm();
		medicineForm.setMedicineDescription(medicineDto.getMedicineDescription());
		medicineForm.setMedicineName(medicineDto.getMedicineName());
		medicineForm.setMedicineId(medicineDto.getMedicineId());
		medicineForm.setMedicinePrice(medicineDto.getMedicinePrice());
		medicineForm.setMedicineSeller(medicineDto.getMedicineSeller());
		medicineForm.setStatus(medicineDto.getStatus());
		return medicineForm;
	}
}
