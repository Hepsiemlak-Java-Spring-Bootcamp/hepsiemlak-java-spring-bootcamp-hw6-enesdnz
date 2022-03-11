package emlakburada.service;

import emlakburada.dto.request.AddressRequest;
import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.repository.BannerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BannerServiceTest {

    @Mock
    private BannerRepository bannerRepository;
    @InjectMocks
    private BannerService bannerService;

    @Test
    @DisplayName("this method tests all banners")
    void getAllBannersTest(){
        List<BannerResponse> allBanners = bannerService.getAllBanners();

        assertNotNull(allBanners);

        assertThat((allBanners).size()).isNotZero();
    }

    @Test
    @DisplayName("this method tests save banner")
    void saveBannerTest(){

        assertThrows(Exception.class, () -> {
            bannerService.saveBanner(prepareBannerRequest());
        }, "İlan kaydedilemedi");
    }

    private BannerRequest prepareBannerRequest(){
        BannerRequest request = new BannerRequest();
        request.setAdvertNo(1);
        request.setPhone("5072140000");
        request.setTotal(50);
        request.setAddress(prepareAddressRequest());
        return request;

    }

    private AddressRequest prepareAddressRequest(){
        AddressRequest request = new AddressRequest();
        request.setAddresDesc("Enes ev");
        request.setDistrict("Çankaya");
        request.setProvince("Ankara");
        return request;

    }


}
