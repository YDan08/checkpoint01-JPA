package br.com.fiap.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.LivroDAOImpl;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.service.GenericService;

public class LivroServiceImpl extends GenericService<Livro, Long>{
    private static LivroServiceImpl instance = null;

    private LivroDAOImpl livroDao;
    private LivroServiceImpl(){
        livroDao = LivroDAOImpl.getInstance();
    }

    public static LivroServiceImpl getInstance(){
        if(instance == null){
            instance = new LivroServiceImpl();
        }
        return instance;
    }

    @Override
    public void cadastrar(Livro instance){
        try{
            livroDao.salvar(instance, getEntityManager());
        }catch( Exception e){
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }finally{
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Livro instance){
        try{
            livroDao.atualizar(instance, getEntityManager());
        }catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}finally {
			closeEntityManager();
		}
    }

    @Override
    public void remover(Long id){
        try{
            livroDao.remover(id, getEntityManager());
        }catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}finally {
			closeEntityManager();
		}
    }

    @Override
    public Livro obter(Long id){
        Livro livro = null;
        try{
            livro = livroDao.obterPorId(id, getEntityManager());
        }catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}finally {
			closeEntityManager();
		}
        return livro;
    }

    @Override
    public List<Livro> listar(){
        List<Livro> livros = null;
        try{
            livros = livroDao.listar(getEntityManager());
        }catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeEntityManager();
		}
        return livros;
    }
}