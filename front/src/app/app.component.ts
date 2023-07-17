import { Component, Renderer2, ViewChild, ElementRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})

export class AppComponent {
  title = 'front';
  apiUrl = 'http://localhost:8080/api/v1/cadastro/inserir';

  // Pessoa
  nomeValue:string = '';
  cpfValue:string = '';
  dataNascimentoValue:Date;
  sexoValue: string = '';
  emailValue:string = '';
  telefoneValue:string = '';
  celularPessoalValue:string = '';
  eWhatsValue:boolean;
  // celularProfissionalValue:string = '';
  pretencaoMinimaValue:number;
  pretencaoMaximaValue:number;

  // Campos de lista
  profissoesText:string = '';
  profissaoValue:string = '';

  habilidadesText:string = '';
  habilidadeValue:string = '';


  // Endereço
  cepValue:string = '';
  logradouroValue:string = '';
  numeroValue:string = '';
  complementoValue:string = '';
  bairroValue:string = '';
  cidadeValue:string = '';
  estadoValue:string = '';
  ufValue:string = '';

  // Experiencias
  experienciasValue: any = [];  
 
  @ViewChild('profissoesCadastradasDiv') profissoesCadastradasDiv: ElementRef;
  empregoAtualValue:boolean;
  profissaoExpValue:string = '';
  salarioValue:number;
  dataContratacaoValue:Date;
  dataDesligamentoValue:Date;
  empresaValue:string = '';
  regimeContratacaoValue: string = '';

  constructor (private renderer: Renderer2, private http: HttpClient){

  }

  onSexChange(event: any){
    this.sexoValue = event.target.value; 
  }
  
  profissoesClick() {
    if (this.profissaoValue.length > 0)
      this.profissoesText += this.profissaoValue + '\n';
    this.profissaoValue = '';
  }

  habilidadesClick() {
    if (this.habilidadeValue.length > 0)
      this.habilidadesText += this.habilidadeValue + '\n';
    this.habilidadeValue = '';
  }

  onRegimeContratacaoChange(event: any){
    this.regimeContratacaoValue = event.target.value; 
  }

  profissaoClick(){
    if (this.profissaoExpValue.length > 0 && !!this.salarioValue && !!this.dataContratacaoValue && this.empresaValue.length > 0 && this.regimeContratacaoValue.length > 0){
      const d: HTMLDivElement = this.renderer.createElement('div');
      d.innerHTML = 
      `
        <div style='padding: 20px; display: flex'>
          <div style='margin-right: 5px; font-weight: bold'>Emprego Atual</div>
          <input type="checkbox" id="empregoAtualId" ${!!this.empregoAtualValue ? 'checked' : ''} disabled>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Profissão</div>
          <div id="profissaoExpId">${this.profissaoExpValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Salário</div>
          <div id="salarioId">${this.salarioValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Data Contratação</div>
          <div id="dataContratacaoId">${this.dataContratacaoValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Data Desligamento</div>
          <div id="dataDesligamentoId">${this.dataDesligamentoValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Empresa</div>
          <div id="empresaId">${this.empresaValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Regime de Contratação</div>
          <div "id="regimeContratacaoId">${this.regimeContratacaoValue}</div>
        </div>
      `;

      this.experienciasValue.push({"empregoAtual": this.empregoAtualValue, "profissao": {"nome": this.profissaoExpValue}, "salario": this.salarioValue, "dataContratacao": this.dataContratacaoValue, "dataDesligamento": this.dataDesligamentoValue, "empresa": this.empresaValue})
      d.className = "secao internaSecao";
      this.renderer.appendChild(this.profissoesCadastradasDiv.nativeElement, d);
      this.renderer.removeClass(this.profissoesCadastradasDiv.nativeElement, "profissoesCadastradasDiv");
      this.empregoAtualValue = false;
      this.profissaoExpValue = '';
      this.salarioValue = 0;
      this.dataContratacaoValue = new Date("");
      this.dataDesligamentoValue = new Date("");
      this.empresaValue = '';
    }
  }

  cadastrar(){
    let profissoes = this.criarArrayProfissoes();
    let habilidades = this.criarArrayHabilidades();
    this.criarObjExperiencias();
    let objetoEnvio = {
      "nome": this.nomeValue,
      "cpf": this.cpfValue,
      "dataNascimento": this.dataNascimentoValue,
      "email": this.emailValue,
      "telefone": this.telefoneValue,
      "pretencaoSalarial": {
        "pretencaoMinima": this.pretencaoMinimaValue,
        "pretencaoMaxima": this.pretencaoMaximaValue
      },
      "sexo": this.sexoValue,
      "celular":{
        "celularNumero": this.celularPessoalValue,
        'celularWhats': this.eWhatsValue
      },
      "endereco": {
        "cep": this.cepValue,
        "logradouro": this.logradouroValue,
        "numero": this.numeroValue,
        "complemento": this.complementoValue,
        "bairro": this.bairroValue,
        "cidade":{
          "nome": this.cidadeValue,
          "estado": this.estadoValue,
          "sigla": this.ufValue
        }
      },
      "profissoes": profissoes,
      "habilidades": habilidades,
      "experiencias": this.experienciasValue
    };
    
    // console.log(objetoEnvio);

    this.http.post<any>(this.apiUrl, objetoEnvio)
      .subscribe(
        resultado => {
          console.log(resultado)
        },
      error => {
        if(error.status == 400) {
          console.log(error);
        }
      }
    );
  }
  criarArrayProfissoes() {
    let lines = this.profissoesText.split(/\n/);
    let value = this.buildArray(lines);
    return value;
  }
  
  criarArrayHabilidades() {
    let lines = this.habilidadesText.split(/\n/);
    let value = this.buildArray(lines);
    return value;
  }
  
  criarObjExperiencias() {
    console.log('Function not implemented.');
  }

  buildArray(value: any){
    let outputText = [];
    for (var i = 0; i < value.length; i++) {
      if (/\S/.test(value[i]))
        outputText.push({ nome: value[i].trim() });
    }
    return outputText;
  }
}

