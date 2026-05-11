package dto;

public record ResultadoOperacaoDTO(
        String operacao,
        double primeiroNumero,
        double segundoNumero,
        double resultado
) {
}