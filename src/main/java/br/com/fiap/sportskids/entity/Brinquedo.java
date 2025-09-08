package br.com.fiap.sportskids.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TDS_MVC_TB_BRINQUEDOS")
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "NM_BRINQUEDO", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Categoria é obrigatória")
    @Column(name = "DS_CATEGORIA", nullable = false, length = 50)
    private String categoria;

    @NotNull(message = "Faixa etária mínima é obrigatória")
    @Min(value = 0, message = "Idade mínima deve ser >= 0")
    @Column(name = "NR_FAIXA_MIN", nullable = false)
    private Integer faixaEtariaMin;

    @NotNull(message = "Faixa etária máxima é obrigatória")
    @Min(value = 0, message = "Idade máxima deve ser >= 0")
    @Column(name = "NR_FAIXA_MAX", nullable = false)
    private Integer faixaEtariaMax;

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "Preço deve ser >= 0")
    @Digits(integer = 10, fraction = 2)
    @Column(name = "VL_PRECO", nullable = false, precision = 12, scale = 2)
    private BigDecimal preco;

    @NotNull(message = "Estoque é obrigatório")
    @Min(value = 0, message = "Estoque deve ser >= 0")
    @Column(name = "QT_ESTOQUE", nullable = false)
    private Integer estoque;

    @Column(name = "NM_MARCA", length = 50)
    private String marca;

    @Column(name = "ST_ATIVO", nullable = false)
    private Boolean ativo = true;

    @Column(name = "DS_DESCRICAO", length = 1000)
    private String descricao;
}
