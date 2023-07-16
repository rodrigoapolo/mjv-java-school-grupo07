import { Component, Renderer2, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})

export class AppComponent {
  title = 'front';
  // @ViewChild('profissoesCadastradas') profissoesCadastradas: ElementRef;
  // profissoesId: number = 0;
  profissoesText = '';
  profissaoValue:string = '';

  habilidadesText = '';
  habilidadeValue:string = '';
 
  @ViewChild('profissoesCadastradasDiv') profissoesCadastradasDiv: ElementRef;
  empregoAtualValue:boolean = false;
  profissaoExpValue:string = '';
  salarioValue:string = '';
  dataContratacaoValue:string = '';
  dataDesligamentoValue:string = '';
  empresaValue:string = '';
  regimeContratacaoValue: string = '';

  constructor (private renderer: Renderer2){

  }
  
  profissoesClick() {
    if (this.profissaoValue.length > 0) {
      this.profissoesText += this.profissaoValue + '\n'
      // const d: HTMLDivElement = this.renderer.createElement('div');
      // d.innerHTML = this.profissaoValue;
      // d.id = String(this.profissoesId);
      // this.profissoesId++;
      // this.renderer.appendChild(this.profissoesCadastradas.nativeElement, d);
    }
    this.profissaoValue = ''
  }

  habilidadesClick() {
    if (this.habilidadeValue.length > 0) {
      this.habilidadesText += this.habilidadeValue + '\n'
    }
    this.habilidadeValue = ''
  }

  onRegimeContratacaoChange(event: any){
    this.regimeContratacaoValue = event.target.value; 
  }

  profissaoClick(){
    console.log(this.empregoAtualValue);
    if (this.profissaoExpValue.length > 0 && this.salarioValue.length > 0 && this.dataContratacaoValue.length > 0 && this.dataDesligamentoValue.length > 0 && this.empresaValue.length > 0 && this.regimeContratacaoValue.length > 0){
      const d: HTMLDivElement = this.renderer.createElement('div');
      d.innerHTML = 
      `
        <div style='padding: 20px; display: flex'>
          <div style='margin-right: 5px; font-weight: bold'>Emprego Atual</div>
          <input type="checkbox" id="empregoAtual" ${!!this.empregoAtualValue ? 'checked' : ''} disabled>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Profissão</div>
          <div>${this.profissaoExpValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Salário</div>
          <div>${this.salarioValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Data Contratação</div>
          <div>${this.dataContratacaoValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Data Desligamento</div>
          <div>${this.dataDesligamentoValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Empresa</div>
          <div>${this.empresaValue}</div>
        </div>
        <div style='padding: 20px'>
          <div style='margin-bottom: 5px; font-weight: bold'>Regime de Contratação</div>
          <div>${this.regimeContratacaoValue}</div>
        </div>
      `;
      d.className = "secao internaSecao";
      this.renderer.appendChild(this.profissoesCadastradasDiv.nativeElement, d);
      this.renderer.removeClass(this.profissoesCadastradasDiv.nativeElement, "profissoesCadastradasDiv");
      this.empregoAtualValue = false;
      this.profissaoExpValue = '';
      this.salarioValue = '';
      this.dataContratacaoValue = '';
      this.dataDesligamentoValue = '';
      this.empresaValue = '';
    }
  }
}
