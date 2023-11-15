<script setup>
import { ref, watch } from "vue";
import { useRouter } from "vue-router";
import { getGugun } from "@/api/trip.js";
const router = useRouter();

const chooseSido = ref("");
const chooseGugun = ref("");
const chooseThema = ref("");
const gugunlist = ref([]);

watch(chooseSido, () => {
  //sido 코드가 변할 때 마다 비동기로 gugun 리스트 가져와서 gugun 리스트에 저장
  getGugun(
    chooseSido.value,
    (res) => {
      chooseGugun.value = "";
      gugunlist.value = res.data;
    },
    (e) => {
      console.log(e);
    }
  );
});
const sidolist = ref([
  { sidoCode: "1", sidoName: "서울특별시" },
  { sidoCode: "2", sidoName: "부산광역시" },
  { sidoCode: "3", sidoName: "대구광역시" },
  { sidoCode: "4", sidoName: "인천광역시" },
  { sidoCode: "5", sidoName: "광주광역시" },
  { sidoCode: "6", sidoName: "대전광역시" },
  { sidoCode: "7", sidoName: "울산광역시" },
  { sidoCode: "8", sidoName: "세종특별자치시" },
  { sidoCode: "31", sidoName: "경기도" },
  { sidoCode: "32", sidoName: "강원도" },
  { sidoCode: "33", sidoName: "충청북도" },
  { sidoCode: "34", sidoName: "충청남도" },
  { sidoCode: "35", sidoName: "경상북도" },
  { sidoCode: "36", sidoName: "경상남도" },
  { sidoCode: "37", sidoName: "전라북도" },
  { sidoCode: "38", sidoName: "전라남도" },
  { sidoCode: "39", sidoName: "제주특별자치도" },
]);

const themalist = ref([
  { themaCode: "12", themaName: "관광지" },
  { themaCode: "14", themaName: "문화시설" },
  { themaCode: "15", themaName: "축제공연행사" },
  { themaCode: "25", themaName: "여행코스" },
  { themaCode: "28", themaName: "레포츠" },
  { themaCode: "32", themaName: "숙박" },
  { themaCode: "38", themaName: "쇼핑" },
  { themaCode: "39", themaName: "음식점" },
]);

function customerSearch() {
  if (chooseSido.value === "") {
    alert("시/도를 선택하세요");
    return;
  }
  if (chooseGugun.value === "") {
    alert("구/군을 선택하세요");
    return;
  }
  if (chooseThema.value === "") {
    alert("테마를 선택하세요");
    return;
  }

  router.push(`/triplist/${chooseSido.value}/${chooseGugun.value}/${chooseThema.value}`);
}
</script>

<template>
  <div>
    <div class="container">
      <slot></slot>
      <form id="form1" class="form-horizontal">
        <div class="form-group">
          <label for="sido"> 시/도 선택 : </label>
          <select class="form-control" id="sido" v-model="chooseSido">
            <option v-for="sido in sidolist" :key="sido.sidoCode" :value="sido.sidoCode">
              {{ sido.sidoName }}
            </option>
          </select>
        </div>
        <div class="form-group">
          <label for="gugun"> 구/군 선택 : </label>
          <select class="form-control" id="gugun" v-model="chooseGugun">
            <option v-for="gugun in gugunlist" :key="gugun.gugun_code" :value="gugun.gugun_code">
              {{ gugun.gugun_name }}
            </option>
          </select>
        </div>

        <div class="form-group">
          <label for="thema">테마:</label>
          <select class="form-control" id="thema" v-model="chooseThema">
            <option v-for="thema in themalist" :key="thema.themaCode" :value="thema.themaCode">
              {{ thema.themaName }}
            </option>
          </select>
        </div>

        <div class="btn-group">
          <input
            type="button"
            class="btn btn-primary"
            value="찾기"
            id="btnInsert"
            @click="customerSearch"
          />
          <input type="reset" class="btn btn-primary" value="초기화" id="btnInit" />
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped></style>
