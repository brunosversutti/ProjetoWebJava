package DTO;

import java.io.Serializable;

import org.apache.commons.fileupload.FileItem;

public class AlunoAtivDTO implements Serializable{
	
	private long codigo;
	private AtividadeDTO atividade;
	private DisciplinaDTO disciplina;
	private AlunoDTO aluno;
	private String nomeArquivo;
	private byte[] arquivo;
	
	private FileItem item;	
	
	public AlunoAtivDTO(){
		
		this.codigo = 0;
		this.atividade = new AtividadeDTO();
		this.aluno = new AlunoDTO();
		this.disciplina = new DisciplinaDTO();
		this.nomeArquivo = "";
		this.arquivo = new byte[0];
		
	}
	
	public AlunoAtivDTO(long Codigo, AtividadeDTO Atividade, DisciplinaDTO Disciplina, AlunoDTO Aluno, String NomeArquivo, byte[] Arquivo){
		this.codigo =  Codigo;
		this.atividade = Atividade;
		this.disciplina = Disciplina;
		this.aluno = Aluno;
		this.nomeArquivo  = NomeArquivo;
		this.arquivo = Arquivo;
	}
	
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public AtividadeDTO getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeDTO atividade) {
		this.atividade = atividade;
	}
	
	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public FileItem getItem() {
		return item;
	}

	public void setItem(FileItem item) {
		this.item = item;
	}
	
	
	
}