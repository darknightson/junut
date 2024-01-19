package com.example.junit.chapter_10;

import com.example.junit.mock.HttpImplTest;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AddressRetrieverTest {

    /*
    // 익명 내부 클래스로 구현은 아래와 같이
    Http anonymousInnerClassHttp = new Http() {
        @Override
        public String get(String url) throws IOException {
            return "{\"address\":{"
                    + "\"house_number\":\"324\","
                    + "\"road\":\"North Tejon Street\","
                    + "\"city\":\"Colorado Springs\","
                    + "\"state\":\"Colorado\","
                    + "\"postcode\":\"80903\","
                    + "\"country_code\":\"us\"}"
                    + "}";
        }
    };
     */
    @Test
    void 유효한_좌표에_대한_적절한_주소에_대한_답변() throws IOException, ParseException {

        // given (준비)
        // 테스트 용도로 하드 코딩한 값을 반환하는 구현체를 스텁이라고 한다(stub)
        // 아래는 람다를 활용한 스텁 구현 방법이다.
        Http http = url ->  "{\"address\":{"
                + "\"house_number\":\"324\","
                + "\"road\":\"North Tejon Street\","
                + "\"city\":\"Colorado Springs\","
                + "\"state\":\"Colorado\","
                + "\"postcode\":\"80903\","
                + "\"country_code\":\"us\"}"
                + "}";

        // when (실행)
        AddressRetriever retriever = new AddressRetriever(http);
        Address address = retriever.retrieve(38.0,-104.0);

        // then (단언 assert)
        assertThat(address.houseNumber).isEqualTo("324");
        assertThat(address.road).isEqualTo("North Tejon Street");
        assertThat(address.city).isEqualTo("Colorado Springs");
        assertThat(address.state).isEqualTo("Colorado");
        assertThat(address.zip).isEqualTo("80903");
    }

    // 만약 위처럼 람다를 쓰지 않고 실제 테스트 구현체를 별도로 만들어서 사용할때
    @Test
    void 유효한_좌표에_대한_적절한_주소에_대한_답변_테스트_구현체_의존_주입() throws IOException, ParseException {

        // given (준비)
        Http http = new HttpImplTest();

        // when (실행)
        AddressRetriever retriever = new AddressRetriever(http);
        Address address = retriever.retrieve(38.0,-104.0);

        // then (단언 assert)
        assertThat(address.houseNumber).isEqualTo("324");
        assertThat(address.road).isEqualTo("North Tejon Street");
        assertThat(address.city).isEqualTo("Colorado Springs");
        assertThat(address.state).isEqualTo("Colorado");
        assertThat(address.zip).isEqualTo("80903");
    }

}