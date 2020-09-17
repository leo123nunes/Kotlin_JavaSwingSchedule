package repository

import contact.ContactEntity

class RepositoryEntity {
    companion object{
        private var contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity){
            contactList.add(contact)
        }

        fun remove(contact: ContactEntity){

        }

        fun getList(): List<ContactEntity>{
            return contactList
        }

    }
}