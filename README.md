O que é ModelMapper:
ModelMapper é uma biblioteca Java que simplifica o processo de conversão entre objetos de tipos diferentes, 
geralmente entre entidades e DTOs (Data Transfer Objects). Ela permite mapear automaticamente as propriedades
de um objeto para outro, sem a necessidade de escrever manualmente o código para copiar cada valor de campo. 
O ModelMapper utiliza reflexão para mapear os campos de maneira inteligente, com base nos nomes e tipos compatíveis,
tornando o processo de conversão mais eficiente e fácil de manter.

Como o ModelMapper pode reduzir o código:
Ao usar o ModelMapper, você elimina a necessidade de escrever código redundante para transferir dados entre objetos.
Em vez de criar um construtor ou usar métodos como BeanUtils.copyProperties(), você pode usar o ModelMapper para realizar
a conversão de forma automática e compacta.

Por exemplo, ao invés de criar um método manual para converter uma entidade em um DTO, como mostrado abaixo:

![p1](https://github.com/user-attachments/assets/0a8f8e62-93ca-4db7-89ed-2e54d558c9f6)
![p2](https://github.com/user-attachments/assets/50eace4d-3b6a-47e0-bddd-8f61509cbeae)
![p3](https://github.com/user-attachments/assets/d3852f21-dc1e-4bc7-8982-3a89ea67f16b)
