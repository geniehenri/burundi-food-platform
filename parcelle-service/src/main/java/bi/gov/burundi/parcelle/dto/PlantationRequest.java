package bi.gov.burundi.parcelle.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PlantationRequest {

    @NotNull
    private UUID parcelleId;

    @NotNull
    private Integer cultureId;

    @NotNull
    private Integer saisonId;

    @NotNull
    private LocalDate dateSemis;

    @NotNull
    @Positive
    private BigDecimal superficieCultiveeHa;

    public UUID getParcelleId() { return parcelleId; }
    public void setParcelleId(UUID parcelleId) { this.parcelleId = parcelleId; }
    public Integer getCultureId() { return cultureId; }
    public void setCultureId(Integer cultureId) { this.cultureId = cultureId; }
    public Integer getSaisonId() { return saisonId; }
    public void setSaisonId(Integer saisonId) { this.saisonId = saisonId; }
    public LocalDate getDateSemis() { return dateSemis; }
    public void setDateSemis(LocalDate dateSemis) { this.dateSemis = dateSemis; }
    public BigDecimal getSuperficieCultiveeHa() { return superficieCultiveeHa; }
    public void setSuperficieCultiveeHa(BigDecimal superficieCultiveeHa) { this.superficieCultiveeHa = superficieCultiveeHa; }
}