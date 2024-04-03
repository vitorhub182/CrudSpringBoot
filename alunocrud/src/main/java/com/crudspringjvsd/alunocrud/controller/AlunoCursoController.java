package com.crudspringjvsd.alunocrud.controller;

import com.crudspringjvsd.alunocrud.entity.AlunoCursoEntity;
import com.crudspringjvsd.alunocrud.entity.AlunoEntity;
import com.crudspringjvsd.alunocrud.entity.CursoEntity;
import com.crudspringjvsd.alunocrud.service.AlunoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoCursoController {
    @Autowired
    private AlunoCursoService _alunocursoService;

    //Request de cursos do aluno
    @RequestMapping(value = "/aluno/{id}/curso", method = RequestMethod.GET)
    public List<CursoEntity> GetCursosByAluno(@PathVariable(value = "id") long id)
    {  List<CursoEntity> listaCursosByAluno = _alunocursoService.GetCursosByAluno(id);
        return listaCursosByAluno;}
    @RequestMapping(value = "/curso/{id}/aluno", method = RequestMethod.GET)
    public List<AlunoEntity> GetAlunosByCurso(@PathVariable(value = "id") long id)
    {  List<AlunoEntity> listaAlunosByCurso = _alunocursoService.GetAlunosByCurso(id);
        return listaAlunosByCurso;}

}
