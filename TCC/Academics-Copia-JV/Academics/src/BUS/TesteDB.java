package BUS;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.Date;

import DAO.AdministradorDAO;
import DAO.AlunoAtivDAO;
import DAO.AlunoDAO;
import DAO.AlunoSemDAO;
import DAO.AtividadeDAO;
import DAO.CursoDAO;
import DAO.CursoProfSemDAO;
import DAO.DBConexao;
import DAO.DisciplinaDAO;
import DAO.EnderecoDAO;
import DAO.ItensDisciplinaDAO;
import DAO.PessoaDAO;
import DAO.ProfSemDAO;
import DAO.ProfessorDAO;
import DAO.SemestreDAO;
import DTO.AdministradorDTO;
import DTO.AlunoAtivDTO;
import DTO.AlunoDTO;
import DTO.AlunoSemDTO;
import DTO.AtividadeDTO;
import DTO.CursoDTO;
import DTO.CursoProfSemDTO;
import DTO.DisciplinaDTO;
import DTO.EnderecoDTO;
import DTO.ItensDisciplinaDTO;
import DTO.ParametrosDTO;
import DTO.CidadeDTO;
import DTO.PessoaDTO;
import DTO.ProfSemDTO;
import DTO.ProfessorDTO;
import DTO.SemestreDTO;
import DAO.CidadeDAO;
import Servlets.ServletDownload;

public class TesteDB {


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConexao db = new DBConexao();
		
		try 
		{
			CidadeDTO cidDTO = new CidadeDTO();
			CidadeDAO cidDAO = new CidadeDAO();
			
			//cidDTO.setCodigo(2);
			//cidDTO.setCidade("ARACATUBA");
			//cidDTO.setUf("SP");
			
			
			//cidDTO = cidDAO.BuscarCidade("ARACATUBA", "SP");
			System.out.println(cidDTO.getCodigo());
			
			//System.out.println( cidDAO.Pesquisar("Aracatuba"));
			
			
			System.out.println(cidDTO.getCidade());

			/**
			PessoaDTO personDTO = new PessoaDTO();
			PessoaDAO personDAO = new PessoaDAO();
			
			personDTO.setCodigo(1);
			personDTO.setCidade(1);
			personDTO.setNome("CARLOS ALEXANDRE");
			personDTO.setNascimento("22121980");
			personDTO.setTelefone("1836310590");
			personDTO.setLogin("carlos");
			personDTO.setSenha("1234");
			personDTO.setRg("296618378");
			personDTO.setCpf("21474202802");
			*/
			
			
			//PessoaDAO personDAO = new PessoaDAO();
			//PessoaDTO personDTO = new PessoaDTO();
			
			
			
			/**
			AdministradorDTO admDTO = new AdministradorDTO();
			AdministradorDAO admDAO = new AdministradorDAO();
			PessoaDTO personDTO = new PessoaDTO();
			personDTO.setCodigo(5);
			admDTO.setCargo("ANALISTA DE SISTEMAS");
			admDTO.setFuncao("GERENTE DE T.I.");
			admDTO.setPessoa(personDTO);
			*/
			/**
			PessoaDAO personDAO = new PessoaDAO();
			PessoaDTO personDTO = new PessoaDTO();
			CidadeDTO cidDTO = new CidadeDTO();
			personDTO.setCodigo(5);
			cidDTO.setCodigo(1);
			EnderecoDTO endDTO = new EnderecoDTO();
			EnderecoDAO endDAO = new EnderecoDAO();
			
			endDTO.setCidade(cidDTO);
			endDTO.setPessoa(personDTO);
			endDTO.setLogradouro("RUA GRACA ARANHA");
			endDTO.setNumero(465);
			endDTO.setComplemento("CASA");
			endDTO.setBairro("ICARAY");
			endDTO.setCep(16020373);
			*/
			/**
			ProfessorDTO profDTO = new ProfessorDTO();
			ProfessorDAO profDAO = new ProfessorDAO();
			PessoaDTO personDTO = new PessoaDTO();
			personDTO.setCodigo(5);
			profDTO.setPessoa(personDTO);
			profDTO.setCodigo(2);
			profDTO.setTitulo("DOUTOR");
			profDTO.setEspecialidade("ENGENHARIA ELETRICA");
			*/
			
			//SemestreDTO semDTO = new SemestreDTO();
			//SemestreDAO semDAO = new SemestreDAO();
			
			
			db.Conectar();
			
			//testes da classe cidade na comunicacao com o banco
			
			//cidDAO.Incluir(cidDTO);
			//cidDAO.Alterar(cidDTO);
			//cidDAO.Excluir(2);
			//cidDAO.Pesquisar(2);
			//cidDAO.Listar();
			//System.out.println(cidDTO.getCidade().toString());
			
			//testes da classe pessoa na comunicacao com o banco
			
			//personDAO.Incluir(personDTO);
			//personDAO.Pesquisar("ALEX");
			//personDAO.Alterar(personDTO);
			//personDAO.Excluir(1);
			
			//testes da classe administrador na comunicacao com o banco
			
			//admDAO.Incluir(admDTO);
			//admDAO.Alterar(admDTO);
			//admDAO.Excluir(2);
			//admDAO.Listar();
			
			
			//testes da classe endereco na comunicacao com o banco
			
			//endDAO.Incluir(endDTO);
			//endDAO.Alterar(endDTO);
			//endDAO.Excluir(1);
			//endDAO.Pesquisar("ALEX");
			//endDAO.Pesquisar(5);
			
			
			//testes da classe professor na comunicacao com o banco
			//profDAO.Incluir(profDTO);
			//profDAO.Alterar(profDTO);
			//profDAO.Excluir(2);
			//profDAO.Listar();
			//profDAO.Pesquisar("ALEX");
			
			//testes da classe semestre na comunicacao com o banco
			
			//semDTO.setCodigo(2);
			//semDTO.setAno(2016);
			//semDTO.setPeriodo("INTEGRAL");
			//semDTO.setStatus("ATIVO");

			//semDAO.Incluir(semDTO);
			//semDAO.Alterar(semDTO);
			//semDAO.Excluir(3);
			//semDAO.Listar();
			
			//testes do relacionamento Professor e Semestre
			/**
			SemestreDTO semDTO = new SemestreDTO();
			ProfessorDTO profDTO = new ProfessorDTO();
			ProfSemDAO profSemDAO = new ProfSemDAO();
			ProfSemDTO profSemDTO = new ProfSemDTO();
			
			
			
			semDTO.setCodigo(5);
			profDTO.setCodigo(3);
			profSemDTO.setProfessor(profDTO);
			profSemDTO.setSemestre(semDTO);
			profSemDTO.setCodigo(1);
			//profSemDAO.Incluir(profSemDTO);
			
			//profSemDAO.Alterar(profSemDTO);
			//profSemDAO.Excluir(1);
			//profSemDAO.Listar();
			*/
			
			/**
			ProfSemDTO profSemDTO = new ProfSemDTO();
			CursoDAO cursoDAO = new CursoDAO();
			profSemDTO.setCodigo(2);
			CursoDTO cursoDTO = new CursoDTO();
			cursoDTO.setProfSemestre(profSemDTO);
			cursoDTO.setNome("DIREITO");
			cursoDTO.setPeriodo("MANHA");
			cursoDTO.setTitulo("BACHAREL");
			cursoDTO.setDuracao(5);
			cursoDTO.setCodigo(2);
			
			//cursoDAO.Incluir(cursoDTO);
			//cursoDAO.Alterar(cursoDTO);
			//cursoDAO.Excluir(2);
			//cursoDAO.Listar();
			
			*/
			
			//testes do relacionamento Professor e Semestre
			
			/**
			
			AlunoDTO alunoDTO = new AlunoDTO();
			AlunoDAO alunoDAO = new AlunoDAO();
			PessoaDTO pessoaDTO = new PessoaDTO();
			CursoDTO cursoDTO = new CursoDTO();
			cursoDTO.setCodigo(3);
			pessoaDTO.setCodigo(5);
			alunoDTO.setPessoa(pessoaDTO);
			alunoDTO.setCurso(cursoDTO);
			alunoDTO.setrA(44182);
			alunoDTO.setSituacao(1);
			alunoDTO.setCodigo(3);
			
			//alunoDAO.Incluir(alunoDTO);
			//alunoDAO.Alterar(alunoDTO);
			//alunoDAO.Excluir(2);
			//alunoDAO.Listar();
			
			*/
			
			/**
			AlunoSemDTO alunoSDTO = new AlunoSemDTO();
			AlunoSemDAO alunoSDAO = new AlunoSemDAO();
			AlunoDTO alunoDTO = new AlunoDTO();
			SemestreDTO semestreDTO = new SemestreDTO();
			
			
			
			alunoDTO.setCodigo(3);
			semestreDTO.setCodigo(4);
			alunoSDTO.setAluno(alunoDTO);
			alunoSDTO.setSemestre(semestreDTO);
			alunoSDTO.setCodigo(1);
			//alunoSDAO.Incluir(alunoSDTO);
			//alunoSDAO.Alterar(alunoSDTO);
			//alunoSDAO.Excluir(1);
			//alunoSDAO.Listar();
			
			*/
			
			/**
			CursoProfSemDTO cProfSemDTO = new CursoProfSemDTO();
			CursoProfSemDAO cProfSemDAO = new CursoProfSemDAO();
			ProfessorDTO profDTO = new ProfessorDTO();
			CursoDTO cursoDTO = new CursoDTO();
			SemestreDTO semDTO = new SemestreDTO();
			profDTO.setCodigo(3);
			cursoDTO.setCodigo(3);
			semDTO.setCodigo(2);
			
			cProfSemDTO.setCurso(cursoDTO);
			cProfSemDTO.setProfessor(profDTO);
			cProfSemDTO.setSemestre(semDTO);
			
			
			//cProfSemDAO.Incluir(cProfSemDTO);
			//cProfSemDAO.Alterar(cProfSemDTO);
			//cProfSemDAO.Excluir(4);
			//cProfSemDAO.Listar();
			
			*/
			
			/**
			DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
			DisciplinaDAO disciplinaDAO =new DisciplinaDAO();
			
			disciplinaDTO.setNome("LOGICA DE PROGRAMACAO");
			disciplinaDTO.setDuracao(1);
			disciplinaDTO.setCodigo(4);
			
			
			//disciplinaDAO.Incluir(disciplinaDTO);
			//disciplinaDAO.Alterar(disciplinaDTO);
			//disciplinaDAO.Excluir(4);
			disciplinaDAO.Listar();
			
			*/
			
			/**
			ItensDisciplinaDTO itDiscDTO = new ItensDisciplinaDTO();
			ItensDisciplinaDAO itDiscDAO = new ItensDisciplinaDAO();
			CursoProfSemDTO cursoProfSem = new CursoProfSemDTO();
			DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
			cursoProfSem.setCodigo(3);
			disciplinaDTO.setCodigo(5);
			itDiscDTO.setCodigo(2);
			itDiscDTO.setCursoprofsem(cursoProfSem);
			itDiscDTO.setDisciplina(disciplinaDTO);
			
			//itDiscDAO.Incluir(itDiscDTO);
			//itDiscDAO.Alterar(itDiscDTO);
			//itDiscDAO.Excluir(2);
			//itDiscDAO.Listar();
			
			*/
			/**
			AtividadeDAO atvDAO = new AtividadeDAO();
			AtividadeDTO atvDTO = new AtividadeDTO();
			ItensDisciplinaDTO itDiscDTO = new ItensDisciplinaDTO();
			
			itDiscDTO.setCodigo(3);
			atvDTO.setItenDisciplina(itDiscDTO);
			atvDTO.setNome("EXERCICIOS");
			atvDTO.setNota(0);
			atvDTO.setTipo(1);
			atvDTO.setCodigo(2);
			
			//atvDAO.Incluir(atvDTO);
			//atvDAO.Alterar(atvDTO);
			//atvDAO.Excluir(2);
			//atvDAO.Listar();

			AlunoAtivDTO  alunoAtvDTO = new AlunoAtivDTO();
			//alunoAtvDTO.setArquivo(new byte[512]);
			 * 
			 * 
			 */
			
			/**
			AlunoAtivDTO alunoAtivDTO = new AlunoAtivDTO();
			AlunoAtivDAO alunoAtivDAO = new AlunoAtivDAO();
			
			alunoAtivDAO.Listar();
				
						*/
/**			
			AlunoAtivDTO alunoAtivDTO = new AlunoAtivDTO();
			AlunoAtivDAO alunoAtivDAO = new AlunoAtivDAO();
			
			alunoAtivDAO.BaixarArquivos("21");
	*/		
			
			System.out.println("Conectado");
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Sem conexao com o DB");
			e.printStackTrace();
		}
		
		
		try
		{
			db.Desconectar();
			System.out.println("Desconectado");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
