
 /*
 *  Classe de paginação para ser usada com o Bootstrap 3.0
 *  Autor: Alex Ishida 
 *  Data: 02/06/2014
 *  Versão: 1.0
 *  GitHub: https://github.com/alexishida/simple-jsp-pagination/ 
 * 
 *  Exemplo de uso dentro de uma pagina JSP
       <% 
                          
            SimpleJspPagination paginacao = new SimpleJspPagination();
            paginacao.setTotalRegistros(100); // Informar o total de registros de todos os dados que queira exibir
            paginacao.setTotalPorPagina(10); // Total de registros por página (Não obrigatorio)
            paginacao.setClassesCSS("pagination-sm"); // coloca uma classe de estilo dentro da ul (Não obrigatorio)
            paginacao.setUrl("noticias.jsp");

            // Se não tiver a pagina no get seta 1 para pagina
            String paginaAtual = "1";
            if (request.getParameter("pagina") != null) {
                  paginaAtual = request.getParameter("pagina");
            } 

            paginacao.setPaginaAtual(paginaAtual);
            out.write(paginacao.paginacaoNumerica());
    %>   
 
 */
package com.alexishida.simplejsppagination;


public class SimpleJspPagination {
    
  
  
    private int totalRegistros = 0;
    private int totalPorPagina = 10;
    private int totalDePaginas = 1;
    private int paginaAtual = 1;
    private String classesCSS = "";
    private String url = "#";

    
    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public int getTotalPorPagina() {
        return totalPorPagina;
    }

    public void setTotalPorPagina(int totalPorPagina) {
        this.totalPorPagina = totalPorPagina;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(String paginaString) {
        try {
            this.paginaAtual = Integer.parseInt(paginaString);
        } catch (NumberFormatException ex) {
            this.paginaAtual = 1;
        }
    }


    public String getClassesCSS() {
        return classesCSS;
    }

    public void setClassesCSS(String classesCSS) {
        this.classesCSS = classesCSS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public String paginacaoNumerica()
    {
        String retorno = "";
        
        this.calculaTotalPaginas();
        
        if(totalDePaginas > 1) {
         
          retorno = "<ul class=\"pagination "+this.getClassesCSS()+ " \">\n";
          retorno = retorno + this.botaoPrimeira();
          retorno = retorno + this.botaoAnterior();
          retorno = retorno + this.botaoNumeros();
          retorno = retorno + this.botaoProxima();
          retorno = retorno + this.botaoUltima();
          retorno = retorno + "</ul>";
          
        }

        return retorno;
     }
    
    
    
    
    public String paginacaoProximaAnterior()
    {
        String retorno = "";
        
        this.calculaTotalPaginas();
        
        if(totalDePaginas > 1) {
         
          retorno = "<ul class=\"pagination "+this.getClassesCSS()+ " \">\n";
          retorno = retorno + this.botaoAnterior2();
          retorno = retorno + this.botaoProxima2();
          retorno = retorno + "</ul>";
          
        }

        return retorno;
     }
    
    
            
            
     private String botaoPrimeira() {
         String retorno = "";
         String desativada = "";
         String url = this.getUrl()+"?pagina=1";
         
         if(this.getPaginaAtual() <= 1) {
            desativada = "class=\"disabled\"";
         }
         
         retorno = "<li "+desativada+" ><a href=\""+url+"\">&larr; Primeira</a></li>\n";
         return retorno;
     }     
     
     
     
      private String botaoAnterior() {
         String retorno = "";
         String desativada = "";
         String url = "";
         
         if(this.getPaginaAtual() <= 1) {
            desativada = "class=\"disabled\"";
            url = this.getUrl()+"?pagina=1";
         }
         else {
            int paginaAnterior = this.getPaginaAtual()-1; 
            url = this.getUrl()+"?pagina="+paginaAnterior;
         }
         
         retorno = "<li "+desativada+" ><a href=\""+url+"\">«</a></li>\n";
       
         return retorno;
     }    
      
      
   
     private String botaoNumeros() {
         String retorno = "";
         String url = "";
         
         
       if(totalDePaginas <= 10)
       {
            for(int total=1;total<=totalDePaginas;total++)
            {
                    url = this.getUrl()+"?pagina="+total;
                    
                    if(total == this.getPaginaAtual())
                    {
                        retorno = retorno + " <li class=\"active\"><a href=\""+url+"\">"+total+"</a></li>";

                    }
                    else
                    {
                         
                         retorno = retorno + " <li><a href=\""+url+"\">"+total+"</a></li>";
                    }

            }
       }
       else {
         
           
           
           
            int sobra_frente = 0;
            int sobra_atras = 0;

            for(int total=((this.getPaginaAtual())-4);total<=((this.getPaginaAtual())-1);total++)
             {
               if(!(total>=1))
               {
                     sobra_frente++;
               }

             }

            for(int total=((this.getPaginaAtual())+1);total<=((this.getPaginaAtual())+4);total++)
            {
               if(!(total<=totalDePaginas))
               {
                  sobra_atras++;
               }

            }
         

            for(int total=((this.getPaginaAtual())-4)-sobra_atras;total<=((this.getPaginaAtual())-1);total++)
            {
              if(total>=1)
              {
               
                   url = this.getUrl()+"?pagina="+total;
                   retorno = retorno + " <li><a href=\""+url+"\">"+total+"</a></li>\n";
              }
              
            }
    
            
            
              url = this.getUrl()+"?pagina="+this.getPaginaAtual();
              retorno = retorno + " <li class=\"active\"><a href=\""+url+"\">"+this.getPaginaAtual()+"</a></li>\n";
            

            for(int total=((this.getPaginaAtual())+1);total<=((this.getPaginaAtual())+4)+sobra_frente;total++)
            {
               if(total<=totalDePaginas)
               {
               
                   url = this.getUrl()+"?pagina="+total;
                   retorno = retorno + " <li><a href=\""+url+"\">"+total+"</a></li>\n";
               }

            }
   
     }
             
         return retorno;
     }   
     
   
      private String botaoProxima() {
         String retorno = "";
         String desativada = "";
         String url = "";
         
         if(this.getPaginaAtual() == totalDePaginas) {
            desativada = "class=\"disabled\"";
            url = this.getUrl()+"?pagina="+totalDePaginas;
         } 
         else {
             int paginaProxima = this.getPaginaAtual()+1;
             url = this.getUrl()+"?pagina="+paginaProxima;
         }
         retorno = "<li "+desativada+" ><a href=\""+url+"\">»</a></li>\n";

         return retorno;
     }     
     
     private String botaoUltima() {
         String retorno = "";
         String desativada = "";
         String url = this.getUrl()+"?pagina="+totalDePaginas;
         
         if(this.getPaginaAtual() == totalDePaginas) {
            desativada = "class=\"disabled\"";
         }
         retorno = "<li "+desativada+" ><a href=\""+url+"\">Última &rarr;</a></li>\n";  
        
         return retorno;
     }   
     
     
      private String botaoProxima2() {
         String retorno = "";
         String desativada = "";
         String url = "";
         
         if(this.getPaginaAtual() == totalDePaginas) {
            desativada = "class=\"disabled\"";
            url = this.getUrl()+"?pagina="+totalDePaginas;
         } 
         else {
             int paginaProxima = this.getPaginaAtual()+1;
             url = this.getUrl()+"?pagina="+paginaProxima;
         }
         retorno = "<li "+desativada+" ><a href=\""+url+"\">Próxima »</a></li>\n";

         return retorno;
     }     
    
      
       private String botaoAnterior2() {
         String retorno = "";
         String desativada = "";
         String url = "";
         
         if(this.getPaginaAtual() <= 1) {
            desativada = "class=\"disabled\"";
            url = this.getUrl()+"?pagina=1";
         }
         else {
            int paginaAnterior = this.getPaginaAtual()-1; 
            url = this.getUrl()+"?pagina="+paginaAnterior;
         }
         
         retorno = "<li "+desativada+" ><a href=\""+url+"\">« Anterior</a></li>\n";
       
         return retorno;
     }    
    
     private void calculaTotalPaginas() {
         double resultado = Math.ceil((double)this.getTotalRegistros()/(double)this.getTotalPorPagina());
         this.totalDePaginas =  (int) resultado;
 
     }
     
     
     
     /* Caso o for usar oracle para fazer a consulta esse método já retorna o rownum inicial e final da consulta baseada na paginação */
     public int[] retornoRowConsultaOracle() {
         int[] retorno = new int[2];
         
         retorno[0] = (paginaAtual-1)*totalPorPagina;
         retorno[1] = paginaAtual*totalPorPagina;
         
         
         System.out.println(retorno[0] + " " + retorno[1]);
         return retorno;
     }
     
     
}