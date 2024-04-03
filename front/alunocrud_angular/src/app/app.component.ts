import { Component, OnInit } from '@angular/core';
import { AlunoService } from './services/aluno.service';
import { Aluno } from './models/aluno';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }

  aluno = {} as Aluno;
  alunos: Aluno[] | undefined; //MODIF

  constructor(private alunoService: AlunoService) {}
  
  ngOnInit() {
    this.getAlunos();
  }

  saveAluno(form: NgForm) {
    if (this.aluno.id !== undefined) {
      this.alunoService.updateAluno(this.aluno).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.alunoService.saveAluno(this.aluno).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  getAlunos() {
    this.alunoService.getAlunos().subscribe((alunos: Aluno[]) => {
      this.alunos = alunos;
    });
  }

  deleteAluno(aluno: Aluno) {
    this.alunoService.deleteAluno(aluno).subscribe(() => {
      this.getAlunos();
    });
  }

  editAluno(aluno: Aluno) {
    this.aluno = { ...aluno };
  }

  // limpa o formulario
  cleanForm(form: NgForm) {
    this.getAlunos();
    form.resetForm();
    this.aluno = {} as Aluno;
  }

}