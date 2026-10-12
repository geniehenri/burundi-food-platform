package bi.gov.burundi.intrant.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "parcelle-service")
public interface ParcelleClient {
}
