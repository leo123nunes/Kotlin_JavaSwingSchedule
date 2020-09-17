package repository

import contact.ContactEntity

class RepositoryEntity {
    companion object{
        private var contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity){
            contactList.add(contact)
        }

        fun remove(contact: ContactEntity){

            var index: Int? = null

            for(item in contactList.withIndex()){
                if(item.value.name==contact.name&&item.value.telephone==contact.telephone){
                    index = item.index
                    break
                }
            }

            if(index!=null){
                contactList.removeAt(index)
            }else{
                throw Exception("Contato não encontrado.")
            }

        }

        fun getList(): List<ContactEntity>{
            return contactList
        }

    }
}