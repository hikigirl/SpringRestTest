package com.test.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.model.AddressDAO;
import com.test.rest.model.AddressDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

//@Controller
//@ResponseBody

//REST API 전용 컨트롤러
@RestController @RequiredArgsConstructor
@Api(value="주소록 컨트롤러", description = "주소록 데이터에 대한 REST API 컨트롤러입니다.")
public class AddressController {
	private final AddressDAO dao;
	
	//기존 방식
	@GetMapping("/m1.do")
	public AddressDTO m1() {
		//AddressDTO - 변환 - JSON
		//1. 직접 문자열로
		//2. JSONObject(json-simple 라이브러리)
		//3. @ResponseBody(jackson-databind)
		
		AddressDTO dto = dao.m1();
		return dto;
	}
	
	//REST API -> tblAddress에 대한 CRUD 작업
	
	//추가하기(C)
	//1. URL을 어떻게 만들 것인가: http://localhost:8080/rest/address
	//2. 메서드? : POST
	//3. 반환값? : Integer
	@PostMapping("/address") 
	@ApiOperation(value = "주소록 추가하기", notes = "주소록 데이터를 추가합니다.")
	public int add(@RequestBody @ApiParam(value="주소록 데이터", required = true) AddressDTO dto) {
		System.out.println("dto: " + dto);
		//x-www-form-urlencoded -> @RequestParam AddressDTO dto
		//JSON raw -> @RequestBody AddressDTO dto
		return dao.add(dto);
	}
	
	//조회하기(R)
	//1. URL을 어떻게 만들 것인가: http://localhost:8080/rest/address
	//2. 메서드? : GET
	//3. 반환값? : List<AddressDTO> -> 변환 -> JSON
	@GetMapping("/address")
	public List<AddressDTO> list() {
		return dao.list();
	}
	
	//수정하기(U)
	//1. URL을 어떻게 만들 것인가: http://localhost:8080/rest/address/101
	//2. 메서드? : PUT(모든 컬럼 수정)
	//3. 반환값? : int
	
	//@RequestMapping(value="/address", method=RequestMethod.PUT)
	@PutMapping("/address/{seq}") //{seq}: 경로 변수(Path variable)
	public int edit(@PathVariable("seq") String seq, @RequestBody AddressDTO dto) {
		dto.setSeq(seq);
		
		return dao.edit(dto);
	}
	
	//삭제하기
	@DeleteMapping("/address/{seq}")
	public int del(@PathVariable("seq") String seq) {
		
		return dao.del(seq);
	}
	
}
