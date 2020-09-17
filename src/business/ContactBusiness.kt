package business

import contact.ContactEntity

import repository.RepositoryEntity

class ContactBusiness {
    private fun validate(nome: String, telefone: String){
        if(nome==""){
            throw Exception("O nome do contato não pode estar vazio.")
        }

        if(telefone==""){
            throw Exception("O numero de telefone não pode estar vazio,")
        }
    }

    private fun validateDelete(nome: String, telefone: String){
        if(nome=="" || telefone==""){
            throw Exception("É necessário selecionar um contato antes de remover.")
        }
    }

    fun save(nome: String, telefone:String){
        validate(nome,telefone)
        var contact = ContactEntity(nome,telefone)
        RepositoryEntity.save(contact)

    }

    fun delete(nome: String, telefone: String){
        validateDelete(nome,telefone)
        var contact = ContactEntity(nome,telefone)
        RepositoryEntity.remove(contact)
    }

    fun getList(): List<ContactEntity>{
        return RepositoryEntity.getList()
    }

    fun getContactsQuantity(): String{
        var list = getList()

         return if(list.isEmpty()){
             "Nenhum contato."
        }else if(list.size==1){
             "${list.size} contato."
        }else{
             "${list.size} contatos."
         }
    }
}