<script setup>
import { ref, watch, onMounted } from "vue";
import { useRouter } from "vue-router";
import { getGugun, getSido } from "@/api/trip.js";
const router = useRouter();

const chooseSido = ref("");
const chooseGugun = ref("");
const chooseThema = ref("");
const gugunlist = ref([]);
const sidolist = ref([]);

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

onMounted(() => {
  getSido(
    (res) => {
      sidolist.value = res.data;
      console.log(sidolist.value);
    },
    (error) => {
      console.log(error);
    }
  );
});

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

  // router.push(`/triplist/${chooseSido.value}/${chooseGugun.value}/${chooseThema.value}`);
}
</script>

<template>
  <div>
    <div class="container">
      <slot></slot>
      <form id="form1" class="form-horizontal">
        <div class="form-group" id="location">
          <div class="form-search">
            <!-- <label for="sido"> 시/도 : </label> -->
            <select class="form-control" id="sido" v-model="chooseSido">
              <option value="" selected disabled>시/도 선택</option>
              <option v-for="sido in sidolist" :key="sido.sido_code" :value="sido.sido_code">
                {{ sido.sido_name }}
              </option>
            </select>
          </div>
          <div class="form-search">
            <!-- <label for="gugun"> 구/군 선택 : </label> -->
            <select class="form-control" id="gugun" v-model="chooseGugun">
              <option value="" selected disabled>구/군 선택</option>
              <option v-for="gugun in gugunlist" :key="gugun.gugun_code" :value="gugun.gugun_code">
                {{ gugun.gugun_name }}
              </option>
            </select>
          </div>
        </div>

        <div class="form-group thema">
          <span v-for="(thema, index) in themalist" :key="thema.themaCode">
            <input
              type="radio"
              :id="thema.themaCode"
              v-model="chooseThema"
              :value="thema.themaCode"
            />
            <label :for="thema.themaCode">{{ thema.themaName }}</label>
          </span>
          <!-- <label for="thema">테마:</label>
          <select class="form-control" id="thema" v-model="chooseThema">
            <option v-for="thema in themalist" :key="thema.themaCode" :value="thema.themaCode">
              {{ thema.themaName }}
            </option>
          </select> -->
        </div>

        <div class="btn-group">
          <input type="button" value="찾기" id="btnInsert" @click="customerSearch" />
          <input type="reset" value="초기화" id="btnInit" />
        </div>
      </form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.thema {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-bottom: 20px;
}
.container {
  width: 100%;
  margin: 0 auto;
}

.btn-group {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-bottom: 20px;

  input {
    width: 120px;
    height: 35px;
    border-radius: 10px;
    border: none;
    background-color: var(--main-color);
  }
}

#location {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: 20px;
  .form-search {
    width: 150px;
    margin: 10px;
  }
}
</style>
