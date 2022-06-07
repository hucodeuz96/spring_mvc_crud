package hucode.repository;

import hucode.entity.StudentCreateDto;

import java.util.List;

public interface Repository<Table,Id> {
    int create(Table model);

     List<StudentCreateDto> read();
    int update(Table model);
    int delete(Id id);
   List <Table> findById(Id id);
}
